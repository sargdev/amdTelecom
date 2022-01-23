package com.sarg.assessment4;

import com.sarg.assessment4.misc.MyClient;
import com.sarg.assessment4.misc.MyProperties;
import com.sarg.assessment4.misc.Utils;
import com.sarg.assessment4.model.Sms;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SmsUtilImpl implements SmsUtil {

    private String token;
    private Sms sms;

    Logger logger = Logger.getLogger(SmsUtilImpl.class.getName());

    HttpClient client = MyClient.getInstance().client;

    /**
     * Initially authenticates, then sends a sms.
     * @return True if sms sent successfully, otherwise false.
     */
    @Override
    public boolean sendSMS() {
        authenticate();
        if(token == null){
            throw new Error("Token must be provided");
        }
        if(sms == null){
            throw new Error("Sms is not provided");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MyProperties.getInstance().getProperty("sms_url")))
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(sms.toString()))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                logger.info("response: " + response.body());
                return true;
            } else {
                throw new Error("Failed to send sms, error code: " + response.statusCode());
            }
        } catch (InterruptedException | IOException e) {
            logger.warning("Exception occurred: " + e.getMessage());
        }
        return false;
    }

    /**
     * Authenticates by sending the APPLICATION_ID combined with APPLICATION_SECRET,
     * and updates the field token.
     */
    private void authenticate(){
        String credentials = Utils.encodeBase64(MyProperties.getInstance().getProperty("app_id")
                +":"+ MyProperties.getInstance().getProperty("app_secret") );

        Map<Object, Object> parameters = new HashMap<>();
        parameters.put("grant_type", "client_credentials");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MyProperties.getInstance().getProperty("auth_url")))
                .header("Authorization", "Basic " + credentials)
                .header("content-type", "application/x-www-form-urlencoded")
                .POST(Utils.ofFormData(parameters))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                token = new JSONObject(response.body()).getString("access_token");
            } else {
                System.out.println("Error with api call");
                throw new Error("failed to authenticate, error code: " + response.statusCode());
            }
        } catch (InterruptedException | IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }


    @Override
    public void setSms(Sms sms) {
        this.sms = sms;
    }
}

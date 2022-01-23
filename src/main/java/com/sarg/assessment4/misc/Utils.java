package com.sarg.assessment4.misc;

import org.json.JSONObject;

import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class Utils {

    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

    public static String encodeBase64(String text){
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    public static double kelvinToCelsius(double tempInKelvin) {
        double celsius;
        celsius = tempInKelvin - 272.15;

        return Math.round(celsius * 10.0) / 10.0;
    }

    public static double parseTempFromWeather(String response) {
        JSONObject weather = new JSONObject(response);

        return weather.getJSONObject("main").getDouble("temp");
    }

}

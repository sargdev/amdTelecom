package com.sarg.assessment4;

import com.sarg.assessment4.model.Sms;

import java.net.http.HttpClient;
import java.util.logging.Logger;

public class WeatherRunnable implements Runnable{

    Logger logger = Logger.getLogger(WeatherRunnable.class.getName());

    private static HttpClient client = HttpClient.newHttpClient();

    private WeatherUtil weatherUtil;
    private SmsUtil smsUtil;

    public WeatherRunnable(WeatherUtil weatherUtil, SmsUtil smsUtil) {
        this.weatherUtil = weatherUtil;
        this.smsUtil = smsUtil;
    }

    @Override
    public void run() {
        weatherUtil.updateWeather();
        double celsius = weatherUtil.getWeather().getTemperature();
        logger.info("Temperature retrieved, Celsius: "+ celsius);
        String smsBody = "";
        smsBody = weatherUtil.getWeather().getCity() + " Temperature ";
        if(celsius > 20){
            smsBody += "more than 20. " + celsius;
        } else {
            smsBody += "less than 20. " + celsius;
        }
        logger.info("Sms body to send: " + smsBody);
        Sms sms = new Sms(smsBody, "+306922222222", "Savvas");
        smsUtil.setSms(sms);
        smsUtil.sendSMS();

    }

}

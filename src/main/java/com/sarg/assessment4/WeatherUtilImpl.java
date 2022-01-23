package com.sarg.assessment4;

import com.sarg.assessment4.misc.MyClient;
import com.sarg.assessment4.misc.MyProperties;
import com.sarg.assessment4.misc.Utils;
import com.sarg.assessment4.model.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class WeatherUtilImpl implements WeatherUtil{

    private Weather weather;

    Logger logger = Logger.getLogger(WeatherUtilImpl.class.getName());

    HttpClient client = MyClient.getInstance().client;

    public WeatherUtilImpl(Weather weather) {
        this.weather = weather;
    }

    /**
     * Retrieves the temperature in Kelvin, converts it in Celsius, and updates weather field.
     */
    @Override
    public void updateWeather(){
        String cityUrl = MyProperties.getInstance().getProperty("weather_url")
                + "?q="
                + weather.getCity()
                + "&appid="
                + MyProperties.getInstance().getProperty("weather_app_id");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(cityUrl))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                double kelvin = Utils.parseTempFromWeather(response.body());
                weather.setTemperature(Utils.kelvinToCelsius(kelvin));

            } else {
                throw new Error("Failed to retrieve weather, error code: " + response.statusCode());
            }
        } catch (InterruptedException | IOException e) {
            logger.warning("Exception occurred: " + e.getMessage());
        }
    }

    @Override
    public Weather getWeather() {
        return weather;
    }

}

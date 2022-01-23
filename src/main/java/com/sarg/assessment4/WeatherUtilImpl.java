package com.sarg.assessment4;

import com.sarg.assessment4.model.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherUtilImpl implements WeatherUtil{

    private final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    private final String WEATHER_APP_ID = "b385aa7d4e568152288b3c9f5c2458a5";

    private Weather weather;

    HttpClient client = ClientSingleton.getInstance().client;

    public WeatherUtilImpl(Weather weather) {
        this.weather = weather;
    }

    /**
     * Retrieves the temperature in Kelvin, converts it in Celsius, and updates weather field.
     */
    @Override
    public void updateWeather(){
        String cityUrl = WEATHER_URL + "?q=" + weather.getCity() + "&appid=" + WEATHER_APP_ID;
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
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @Override
    public Weather getWeather() {
        return weather;
    }

}

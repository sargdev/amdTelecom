package com.sarg;

import com.sarg.assessment4.Assessment4;
import com.sarg.assessment4.Unit;
import com.sarg.assessment4.WeatherUtilImpl;
import com.sarg.assessment4.model.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Assessment4Test {


    @Test
    void shouldCallWeatherUtil() throws InterruptedException {
        Assessment4 assessment4 = new Assessment4();
        assessment4.checkWeather();
        Thread.sleep(5000);

    }

    @Test
    @Disabled
    void shouldUpdateWeatherWithTemperature(){
        Weather weather = new Weather("thessaloniki", Unit.CELSIUS);
        WeatherUtilImpl weatherUtil = new WeatherUtilImpl(weather);
        Assertions.assertEquals(0.0, weatherUtil.getWeather().getTemperature());
        weatherUtil.updateWeather();

        System.out.println(weatherUtil.getWeather().getTemperature());
        System.out.println(weatherUtil.getWeather().getCity());
        System.out.println(weatherUtil.getWeather().getUnit());

    }



}
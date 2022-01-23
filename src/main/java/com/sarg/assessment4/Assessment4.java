package com.sarg.assessment4;

import com.sarg.assessment4.model.Weather;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Assessment4 {

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);


    public void checkWeather() {
        Weather weather = new Weather("Thessaloniki", Unit.CELSIUS);

        final ScheduledFuture<?> weatherHandle =
                scheduler.scheduleAtFixedRate(new WeatherRunnable(new WeatherUtilImpl(weather),new SmsUtilImpl()), 0, 10, SECONDS);
        scheduler.schedule(() -> { weatherHandle.cancel(true); }, 10 , SECONDS);
    }

}

package com.sarg.assessment4.model;


//import temp.sarg.assessment4.Unit;

import com.sarg.assessment4.Unit;

public class Weather {

    private String city;
    private Unit unit;
    private double temperature;

    public Weather(String city, Unit unit) {
        this.city = city;
        this.unit = unit;
    }
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}

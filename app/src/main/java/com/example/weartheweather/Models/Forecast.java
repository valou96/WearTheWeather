package com.example.weartheweather.Models;

import com.example.weartheweather.Models.Weather;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Forecast implements Serializable {
    @SerializedName("dt")
    private int datetime;
    @SerializedName("main")
    Main main;
    @SerializedName("weather")
    Weather weather;



    public Forecast(int datetime, Main main , Weather weather ) {
        this.weather = weather;
        this.datetime = datetime;
        this.main = main;
    }
}
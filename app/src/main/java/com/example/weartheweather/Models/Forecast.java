package com.example.weartheweather.Models;

import com.example.weartheweather.Models.Weather;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Forecast implements Serializable {
    @SerializedName("main")
    Weather weather;
    @SerializedName("dt")
    private int datetime;
    public Forecast(Weather weather, int datetime) {
        this.weather = weather;
        this.datetime = datetime;
    }
}
package com.example.weartheweather;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {
    @SerializedName("description")
    private double description;


    public double getTemp() {
        return description;
    }
}
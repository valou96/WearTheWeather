package com.example.weartheweather;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {
    @SerializedName("temp")
    private double temp;


    public double getTemp() {
        return temp;
    }
}
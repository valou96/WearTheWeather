package com.example.weartheweather.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {
    @SerializedName("temp")
    private double temp;


    public double getTemp() {
        return temp;
    }
}
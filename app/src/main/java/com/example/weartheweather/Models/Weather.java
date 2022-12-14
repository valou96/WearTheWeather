package com.example.weartheweather.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {
    @SerializedName("description")
    private double description;
    @SerializedName("icon")
    private int icon;

    public int getIcon() {
        return icon;
    }
}
package com.example.weartheweather.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Main implements Serializable {
    @SerializedName("temp")
    private double temp;
    @SerializedName("feels_like")
    private double feels_like;
    @SerializedName("temp_min")
    private double temp_min;
    @SerializedName("temp_max")
    private double temp_max;
    @SerializedName("humidity")
    private double humidity;




    public double getTemp() {
        return temp;
    }
    public double getFeels_like() {return feels_like;}

    public double getTemp_min() {return temp_min;}

    public double getTemp_max() {return temp_max;}

    public double getHumidity() {return humidity;}

}

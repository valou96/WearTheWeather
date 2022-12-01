package com.example.weartheweather.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Forecast implements Serializable {


    @SerializedName("list")
    private ArrayList<Forecast> Forecasts;
    @SerializedName("dt")
    private int datetime;
    @SerializedName("main")
    Main main;

    Date time = new java.util.Date(datetime);

    public Date getTime() {
        return time;
    }

    public Forecast(int datetime, Main main) {

        this.datetime = datetime;
        this.main = main;
    }

    public int getDatetime() {
        return datetime;
    }

    public Main getMain() {
        return main;
    }

    public ArrayList<Forecast> getForecasts() {
        return Forecasts;
    }

}

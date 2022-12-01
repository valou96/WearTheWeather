package com.example.weartheweather;

import com.example.weartheweather.Models.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenWeatherServices {

    @GET("forecast?lat=44.34&lon=10.99&appid=e075a0b59517e88cc46940bb262add13")
    Call<Forecast> getForecasts();


}

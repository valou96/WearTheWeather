package com.example.weartheweather.Interfaces;

import com.example.weartheweather.Models.Forecast;
import com.example.weartheweather.Models.Main;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenWeatherServices {

    @GET("forecast?lat=45.89&lon=6.12&appid=e075a0b59517e88cc46940bb262add13")
    Call<Forecast> getForecasts();

    @GET("forecast?lat=45.89&lon=6.12&appid=e075a0b59517e88cc46940bb262add13")
    Call<Main> getMain();


}

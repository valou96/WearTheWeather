package com.example.weartheweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weartheweather.Models.Forecast;
import com.example.weartheweather.databinding.ActivityClothBinding;
import com.example.weartheweather.databinding.ActivityMainBinding;

public class ClothActivity extends AppCompatActivity {
    private ActivityClothBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClothBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //PutExtras pour la meteo J+1
        Intent myIntent = getIntent();
        Forecast myForecast = (Forecast)myIntent.getSerializableExtra("Meteo");
        binding.idDateselect.setText(String.valueOf(myForecast.getDatetime()));








    }
}
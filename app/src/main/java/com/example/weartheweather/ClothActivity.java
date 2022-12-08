package com.example.weartheweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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
    }
}
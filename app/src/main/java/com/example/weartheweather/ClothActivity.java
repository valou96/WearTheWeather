package com.example.weartheweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.weartheweather.Adapters.RecyclerViewAdapterDateduJour;
import com.example.weartheweather.Interfaces.OpenWeatherServices;
import com.example.weartheweather.Models.Forecast;
import com.example.weartheweather.Models.Main;
import com.example.weartheweather.Models.RetrofitClientInstance;
import com.example.weartheweather.databinding.ActivityClothBinding;
import com.example.weartheweather.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        binding.IdBtnCasual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.IdImageView.setImageResource(R.drawable.imgchaudcasual);
            }
        });

        binding.IdBtnChic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.IdImageView.setImageResource(R.drawable.imgchaudchic);
            }
        });

        binding.IdBtnSportsWear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.IdImageView.setImageResource(R.drawable.imgchaudsportwear);
            }
        });


        OpenWeatherServices service =
                RetrofitClientInstance.getRetrofitInstance().create(OpenWeatherServices.
                        class);
        Call<Main> call = service.getMain();
        call.enqueue(new Callback<Main>() {
            @Override
            public void onResponse(Call<Main> call, Response<Main>
                    response) {
                Main main = response.body();
                if(main.getTemp() > -1) {
                    binding.IdImageView.setImageResource(R.drawable.imgmanequinnue);
                }

            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) {
                Toast.makeText(ClothActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });








    }
}
package com.example.weartheweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.weartheweather.Models.Forecast;
import com.example.weartheweather.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Forecast> Meteos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        OpenWeatherServices service =
                RetrofitClientInstance.getRetrofitInstance().create(OpenWeatherServices.
                        class);
        Call<Forecast> call = service.getForecasts();
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast>
                    response) {
                Forecast forecast = response.body();
                binding.TxtmeteoplusUn.setText(String.valueOf(forecast.getForecasts().get(0).getDatetime()));
                binding.TxtmeteoplusDeux.setText(String.valueOf(forecast.getForecasts().get(7).getDatetime()));
                binding.TxtmeteoplusTrois.setText(String.valueOf(forecast.getForecasts().get(15).getDatetime()));
                binding.TxtmeteoplusQuatre.setText(String.valueOf(forecast.getForecasts().get(23).getDatetime()));
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

        /*
        Meteos = new ArrayList<Forecast>();
        Meteos.add(new Forecast()); // a completer selon données API
        binding.rvjour.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        binding.rvjour.setLayoutManager(layoutManager);
        binding.rvjour.setFocusable(false);

        RecyclerAdapter myAdapterAnimals = new RecyclerAdapter(Meteos);
        binding.rvjour.setAdapter(myAdapterAnimals);

         */
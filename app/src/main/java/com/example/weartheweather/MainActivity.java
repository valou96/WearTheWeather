package com.example.weartheweather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.weartheweather.Adapters.RecyclerViewAdapterDateduJour;
import com.example.weartheweather.Interfaces.OpenWeatherServices;
import com.example.weartheweather.Models.Forecast;
import com.example.weartheweather.Models.Main;
import com.example.weartheweather.Models.RetrofitClientInstance;
import com.example.weartheweather.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Forecast> Meteos;
    private List<Forecast> dataForecast;
    private RecyclerViewAdapterDateduJour dateduJour;






    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new  ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == 1){
                Intent resultIntent = result.getData();
                if(resultIntent != null){
                    //Log.d("Resultat", resultIntent.getSerializableExtra("monObjetRecupere").toString() );
                }
            }
        }
    });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ArrayList<Forecast> forecasts = new ArrayList<>();
        forecasts.add(new Forecast(10022022, new Main(28.3)));
        forecasts.add(new Forecast(10082022, new Main(26.3)));
        forecasts.add(new Forecast(10052022, new Main(22.9)));

        binding.rvDateDuJour.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvDateDuJour.setLayoutManager(layoutManager);
        binding.rvDateDuJour.setFocusable(false);

        RecyclerViewAdapterDateduJour myAdapterdateDuJour = new RecyclerViewAdapterDateduJour(forecasts);
        binding.rvDateDuJour.setAdapter(myAdapterdateDuJour);

        binding.TxtmeteoplusUn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ClothActivity.class);
                //intent.putExtra(); // voir put extra avec M.Tissot
                startActivity(intent);
            }
        });

        binding.TxtmeteoplusDeux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ClothActivity.class);
                startActivity(intent);
            }
        });

        binding.TxtmeteoplusTrois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ClothActivity.class);
                startActivity(intent);
            }
        });

        binding.TxtmeteoplusQuatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ClothActivity.class);
                startActivity(intent);
            }
        });


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
package com.mamunsproject.wheatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.mamunsproject.wheatherapp.Retrofit.WeatherApiClient;
import com.mamunsproject.wheatherapp.Retrofit.WeatherApiInterface;
import com.mamunsproject.wheatherapp.Retrofit.WeatherExample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    ImageView search;
    TextView tempText,descText,humidityText;
    EditText textField;

    LottieAnimationView cloud,progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity_main);
        getSupportActionBar().hide();


        search=findViewById(R.id.searchIcon);
        tempText=findViewById(R.id.tempText);
        descText=findViewById(R.id.descText);
        humidityText=findViewById(R.id.humidityText);
        textField=findViewById(R.id.textField);

        progressBar=findViewById(R.id.progressBar);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Here We Will Call Api


                getWeatherData(textField.getText().toString().trim() );


            }
        });
    }

    private void getWeatherData(String name){

        progressBar.setVisibility(View.VISIBLE);
        WeatherApiInterface weatherApiInterface = WeatherApiClient.getClient().create(WeatherApiInterface.class);
        Call<WeatherExample> call= weatherApiInterface.getWeatherData(name);


        call.enqueue(new Callback<WeatherExample>() {
            @Override
            public void onResponse(Call<WeatherExample> call, Response<WeatherExample> response) {

                progressBar.setVisibility(View.INVISIBLE);

                tempText.setText(response.body().getWeatherMain().getTemp()+"°");
                descText.setText(response.body().getWeatherMain().getFeels_like()+"°");
                humidityText.setText(response.body().getWeatherMain().getHumidity());



            }

            @Override
            public void onFailure(Call<WeatherExample> call, Throwable t) {

                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(WeatherActivity.this, "Correct City Name", Toast.LENGTH_SHORT).show();
            }
        });

    }
}















































































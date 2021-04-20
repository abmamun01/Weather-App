package com.mamunsproject.wheatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class WeatherExample {


    @SerializedName("main")
    private WeatherMain weatherMain;

    public WeatherMain getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(WeatherMain weatherMain) {
        this.weatherMain = weatherMain;
    }
}

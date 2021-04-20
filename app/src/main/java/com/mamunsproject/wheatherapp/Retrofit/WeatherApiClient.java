package com.mamunsproject.wheatherapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiClient {


    private static Retrofit retrofit=null;

    public static  Retrofit getClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().
                    baseUrl("https://api.openweathermap.org/data/2.5/").addConverterFactory
                    (GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}

package com.mamunsproject.wheatherapp.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {

   // @GET("https://api.openweathermap.org/data/2.5/weather?q=Karachi&appid=cf66236fd3fbb70d4867ed4181b3b398&units=metric")
                                                    //AKHAN THEKE  SORIYE FELBO JATE Q TA SEARCH KORTE PARI
    @GET("weather?&appid=cf66236fd3fbb70d4867ed4181b3b398&units=metric")
                                //Akhane q mane search korbo country name
    Call<WeatherExample> getWeatherData(@Query("q") String name);

}

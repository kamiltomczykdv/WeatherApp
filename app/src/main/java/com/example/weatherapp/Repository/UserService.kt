package com.example.weatherapp.Repository

import com.example.weatherapp.Model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {


    @GET("/data/2.5/group")
    fun getWeather(@Query("id")ids:String, @Query("APPID")apiKey:String ):Single<WeatherResponse>

}
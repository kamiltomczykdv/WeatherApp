package com.example.weatherapp.Repository

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.Model.WeatherResponse
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor(var userService: UserService) {
    private val apiKey:String="cb2f6467000f988a23719ebd55f038d0"
    private val europe:String= "2988507,2643743,756135,524901"
    private val africa:String= "993800,360630,2332459,2253354"
    private val asia:String= "5808453,1835848,1816670,1609350"
    private val southamerica:String= "3451190,3435910,3936456,3688689"
    private val northamerica:String= "5128581,5368361,6167865,6077243"
    private lateinit var cn:ConnectivityManager



    fun getEurope():Single<WeatherResponse>{
        return userService.getWeather(europe,apiKey)
    }

    fun getAfrica():Single<WeatherResponse>{
        return userService.getWeather(africa,apiKey)
    }

    fun getAsia():Single<WeatherResponse>{
        return userService.getWeather(asia,apiKey)
    }

    fun getSouthAmerica():Single<WeatherResponse>{
        return userService.getWeather(southamerica,apiKey)
    }

    fun getNorthAmerica():Single<WeatherResponse>{
        return userService.getWeather(northamerica,apiKey)
    }

    fun checkInternetConnection(activity:AppCompatActivity):Boolean{
        cn=activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cn.activeNetworkInfo?.isConnected ?: false
    }




}
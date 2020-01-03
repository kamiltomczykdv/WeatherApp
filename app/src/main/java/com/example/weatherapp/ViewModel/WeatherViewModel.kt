package com.example.weatherapp.ViewModel

import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.Model.WeatherResponse
import com.example.weatherapp.Repository.Repository
import io.reactivex.Single
import javax.inject.Inject

class WeatherViewModel @Inject constructor(val userRepository: Repository) {

    fun getEuropeVM(): Single<WeatherResponse>{return userRepository.getEurope()}
    fun getAfricaVM(): Single<WeatherResponse>{return userRepository.getAfrica()}
    fun getAsiaVM(): Single<WeatherResponse>{return userRepository.getAsia()}
    fun getSouthAmericaVM(): Single<WeatherResponse>{return userRepository.getSouthAmerica()}
    fun getNorthAmericaVM(): Single<WeatherResponse>{return userRepository.getNorthAmerica()}
    fun checkInternetConnectionVM(activity: AppCompatActivity):Boolean{return userRepository.checkInternetConnection(activity)}

}
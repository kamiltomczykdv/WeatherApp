package com.example.weatherapp.Model

class WeatherResponse(c:Int,l:List<CityWeather>) {
    var cnt:Int
    var list:List<CityWeather>

    init {
        this.cnt=c
        this.list=l
    }
}
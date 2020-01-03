package com.example.weatherapp.Model

class SystemWeather( i:Int, c:String, s:Long, sn:Long) {
    var country:String
    var timezone:Int
    var sunrise:Long
    var sunset:Long

    init {
        this.country=c
        this.timezone=i
        this.sunrise=s
        this.sunset=sn
    }
}
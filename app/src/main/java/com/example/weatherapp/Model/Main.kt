package com.example.weatherapp.Model

class Main(t:Double,p:Int,h:Int,tmn:Double,tmx:Double) {
    var temp:Double
    var pressure:Int
    var humidity:Int
    var temp_min:Double
    var temp_max:Double

    init {
        this.temp=t
        this.pressure=p
        this.humidity=h
        this.temp_min=tmn
        this.temp_max=tmx
    }
}
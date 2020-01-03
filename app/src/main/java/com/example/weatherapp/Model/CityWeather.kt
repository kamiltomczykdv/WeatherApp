package com.example.weatherapp.Model

class CityWeather(c:Coord, s:SystemWeather, w:ArrayList<Weather>, m:Main, v:Int, wi:Wind, cl:Clouds, d:Long, i:Long, n:String) {
    var coord:Coord
    var sys:SystemWeather
    var weather=ArrayList<Weather>()
    var main:Main
    var visibility:Int
    var wind:Wind
    var clouds:Clouds
    var dt:Long
    var id:Long
    var name:String

    init {
        this.coord=c
        this.sys=s
        this.weather=w
        this.main=m
        this.visibility=v
        this.wind=wi
        this.clouds=cl
        this.dt=d
        this.id=i
        this.name=n
    }
}
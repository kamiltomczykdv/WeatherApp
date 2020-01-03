package com.example.weatherapp.Model

class Weather(i:Int,m:String,d:String,ic:String) {
    var id:Int
    var main:String
    var description:String
    var icon:String

    init {
        this.id=i
        this.main=m
        this.description=d
        this.icon=ic
    }
}
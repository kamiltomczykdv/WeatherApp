package com.example.weatherapp.Storage

interface Storage {
    fun setString(key:String,value:String)
    fun getString(key: String):String
}
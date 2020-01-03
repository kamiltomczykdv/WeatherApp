package com.example.weatherapp

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.DI.AppComponent
import com.example.weatherapp.DI.DaggerAppComponent

open class MyApp:Application() {

    val appComponent: AppComponent by lazy {
        initComponent()
    }

    open fun initComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }






}
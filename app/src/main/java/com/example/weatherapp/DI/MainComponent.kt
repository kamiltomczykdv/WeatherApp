package com.example.weatherapp.DI

import com.example.weatherapp.View.MainActivity
import com.example.weatherapp.View.NameActivity
import com.example.weatherapp.View.SplashActivity
import dagger.Subcomponent

@Subcomponent
interface MainComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():MainComponent
    }
    fun inject(activity:MainActivity)
    fun inject(activity:NameActivity)
    fun inject(activity:SplashActivity)
}
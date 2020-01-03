package com.example.weatherapp.DI

import com.example.weatherapp.View.CardActivity
import dagger.Subcomponent


@Subcomponent
interface CardComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():CardComponent
    }

    fun inject(activity:CardActivity)
}
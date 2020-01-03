package com.example.weatherapp.Repository

import com.example.weatherapp.DI.MainComponent
import com.example.weatherapp.Storage.SharedPreferencesStorage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NameManager @Inject constructor(val storage: SharedPreferencesStorage,val mainComponent: MainComponent.Factory) {
    val userName:String
    get() = storage.getString("name")

    var mainCo:MainComponent?=null
    private set

    fun isUserExists()=storage.getString("name").isNotEmpty()
    fun setName(name:String){
        storage.setString("name",name)
        mainCo=mainComponent.create()
    }

}
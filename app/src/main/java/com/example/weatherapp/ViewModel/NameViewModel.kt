package com.example.weatherapp.ViewModel

import com.example.weatherapp.Repository.NameManager
import javax.inject.Inject

class NameViewModel @Inject constructor(val nameManager: NameManager) {

    fun getNameVM():String{
        return nameManager.userName
    }

    fun isUserExistsVM():Boolean{
        return nameManager.isUserExists()
    }

    fun setNameVM(name:String){nameManager.setName(name)}
}
package com.example.weatherapp.View

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.MyApp
import com.example.weatherapp.R
import com.example.weatherapp.ViewModel.NameViewModel
import javax.inject.Inject

class SplashActivity:AppCompatActivity() {
    @Inject
    lateinit var nameViewModel: NameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApp).appComponent.mainComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        Handler().postDelayed({
            if(nameViewModel.isUserExistsVM()){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            else{
                startActivity(Intent(this, NameActivity::class.java))
                finish()
            }


        },2000)


    }
}
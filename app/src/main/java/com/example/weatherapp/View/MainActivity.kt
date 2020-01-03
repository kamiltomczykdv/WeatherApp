package com.example.weatherapp.View

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.example.weatherapp.MyApp
import com.example.weatherapp.R
import com.example.weatherapp.Storage.SharedPreferencesStorage
import com.example.weatherapp.ViewModel.NameViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var nameViewModel: NameViewModel



    lateinit var lottie:LottieAnimationView
    lateinit var eu_b:Button
    lateinit var af_b:Button
    lateinit var as_b:Button
    lateinit var sam_b:Button
    lateinit var nam_b:Button
    lateinit var text:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApp).appComponent.mainComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        lottie=findViewById(R.id.intro)
        lottie.playAnimation()
        init()

        text.text="Hello "+nameViewModel.getNameVM()

        val intent= Intent(this,CardActivity::class.java)

        eu_b.setOnClickListener{
            intent.putExtra("continent",1)
            startActivity(intent)
        }

        af_b.setOnClickListener{
            intent.putExtra("continent",2)
            startActivity(intent)
        }

        as_b.setOnClickListener{
            intent.putExtra("continent",3)
            startActivity(intent)
        }

        sam_b.setOnClickListener{
            intent.putExtra("continent",4)
            startActivity(intent)
        }

        nam_b.setOnClickListener{
            intent.putExtra("continent",5)
            startActivity(intent)
        }


    }

    fun init(){
        eu_b=findViewById(R.id.europe_b)
        af_b=findViewById(R.id.africa_b)
        as_b=findViewById(R.id.asia_b)
        sam_b=findViewById(R.id.south_america_b)
        nam_b=findViewById(R.id.north_america_b)
        text=findViewById(R.id.hello)
    }
}

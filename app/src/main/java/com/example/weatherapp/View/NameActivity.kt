package com.example.weatherapp.View

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.MyApp
import com.example.weatherapp.R
import com.example.weatherapp.ViewModel.NameViewModel
import com.google.android.material.textfield.TextInputEditText
import javax.inject.Inject

class NameActivity:AppCompatActivity() {
    @Inject
    lateinit var nameViewModel: NameViewModel

    lateinit var cn:Button
    lateinit var edit:TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApp).appComponent.mainComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.name_layout)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        init()

        cn.setOnClickListener {
            if(edit.text!!.isNotEmpty()){
                nameViewModel.setNameVM(edit.text.toString())
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this,"Enter your name",Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun init(){
        cn=findViewById(R.id.cn)
        edit=findViewById(R.id.edit)
    }
}
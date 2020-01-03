package com.example.weatherapp.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Model.CityWeather
import com.example.weatherapp.R

class ModelAdapter : RecyclerView.Adapter<ModelAdapter.ViewHolder>(){
    lateinit var weathers:List<CityWeather>

    fun setWeather(list: List<CityWeather>){
        this.weathers=list
    }

    public class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView =view.findViewById(R.id.city_name)
        val tempText:TextView=view.findViewById(R.id.temp_text)
        val hText: TextView =view.findViewById(R.id.humidity_text)
        val pText:TextView=view.findViewById(R.id.pressure_text)
        val fText: TextView =view.findViewById(R.id.flag_text)
        val cText:TextView=view.findViewById(R.id.cloud_text)
        val wText: TextView =view.findViewById(R.id.wind_text)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.single,p0,false))
    }

    override fun getItemCount(): Int {return weathers.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.title.text=weathers[p1].name
        p0.tempText.text= weathers[p1].main.temp.toString()+"F"
        p0.hText.text=weathers[p1].main.humidity.toString()+"%"
        p0.pText.text=weathers[p1].main.pressure.toString()+"hPa"
        p0.fText.text=weathers[p1].sys.country
        p0.cText.text=weathers[p1].clouds.all.toString()+"%"
        p0.wText.text=weathers[p1].wind.speed.toString()+"m/s"
    }


}
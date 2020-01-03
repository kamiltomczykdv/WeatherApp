package com.example.weatherapp.View

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Model.WeatherResponse
import com.example.weatherapp.MyApp
import com.example.weatherapp.R
import com.example.weatherapp.ViewModel.WeatherViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CardActivity:AppCompatActivity() {
    @Inject
    lateinit var weatherViewModel: WeatherViewModel

    @Inject
    lateinit var modelAdapter: ModelAdapter

    @Inject
    lateinit var gridLayoutManager: GridLayoutManager

    lateinit var recyclerView: RecyclerView
    lateinit var back: Button
    lateinit var progressBar: ProgressBar

    var disposable: Disposable?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApp).appComponent.cardComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_net)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        init()


        val continent:Int=intent.getIntExtra("continent",0)

        back.setOnClickListener {
            finish()
        }

        if(weatherViewModel.checkInternetConnectionVM(this)){
            when(continent){
                0->Toast.makeText(applicationContext,"ERROR", Toast.LENGTH_LONG).show()
                1->weatherViewModel.getEuropeVM().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object :SingleObserver<WeatherResponse>{
                        override fun onSuccess(t: WeatherResponse) {
                            initAdapter(t)
                        }

                        override fun onSubscribe(d: Disposable) {
                            disposable=d
                        }

                        override fun onError(e: Throwable) {
                            Toast.makeText(applicationContext,"ERROR", Toast.LENGTH_LONG).show()
                        }

                    })

                2->weatherViewModel.getAfricaVM().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object :SingleObserver<WeatherResponse>{
                        override fun onSuccess(t: WeatherResponse) {
                            initAdapter(t)
                        }

                        override fun onSubscribe(d: Disposable) {
                            disposable=d
                        }

                        override fun onError(e: Throwable) {
                            Toast.makeText(applicationContext,"ERROR", Toast.LENGTH_LONG).show()

                        }

                    })

                3->weatherViewModel.getAsiaVM().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object :SingleObserver<WeatherResponse>{
                        override fun onSuccess(t: WeatherResponse) {
                            initAdapter(t)
                        }

                        override fun onSubscribe(d: Disposable) {
                            disposable=d
                        }

                        override fun onError(e: Throwable) {
                            Toast.makeText(applicationContext,"ERROR", Toast.LENGTH_LONG).show()

                        }

                    })

                4->weatherViewModel.getSouthAmericaVM().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object :SingleObserver<WeatherResponse>{
                        override fun onSuccess(t: WeatherResponse) {
                            initAdapter(t)
                        }

                        override fun onSubscribe(d: Disposable) {
                            disposable=d
                        }

                        override fun onError(e: Throwable) {
                            Toast.makeText(applicationContext,"ERROR", Toast.LENGTH_LONG).show()

                        }

                    })

                5->weatherViewModel.getNorthAmericaVM().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object :SingleObserver<WeatherResponse>{
                        override fun onSuccess(t: WeatherResponse) {
                            initAdapter(t)
                        }

                        override fun onSubscribe(d: Disposable) {
                            disposable=d
                        }

                        override fun onError(e: Throwable) {
                            Toast.makeText(applicationContext,"ERROR", Toast.LENGTH_LONG).show()

                        }

                    })

            }
        }
        else{
            Toast.makeText(this,"No internet connection",Toast.LENGTH_LONG).show()
            progressBar.visibility=View.INVISIBLE
        }


    }

    private fun init(){
        recyclerView=findViewById(R.id.recycler)
        back=findViewById(R.id.materialButton)
        progressBar=findViewById(R.id.progressBar)
        progressBar.visibility= View.VISIBLE
    }

    private fun initAdapter(re:WeatherResponse){
        progressBar.visibility=View.INVISIBLE
        modelAdapter.setWeather(re.list)
        recyclerView.layoutManager=gridLayoutManager
        recyclerView.adapter=modelAdapter
        modelAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(disposable!=null)disposable?.dispose()
        recyclerView.layoutManager=null
    }


}
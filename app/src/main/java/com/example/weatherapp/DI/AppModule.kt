package com.example.weatherapp.DI


import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import com.example.weatherapp.Repository.NameManager
import com.example.weatherapp.Repository.UserService
import com.example.weatherapp.Storage.SharedPreferencesStorage
import com.example.weatherapp.View.ModelAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    private val baseUrl:String="http://api.openweathermap.org"

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl).build()
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit):UserService=retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideStorage(context: Context):SharedPreferencesStorage{
        return SharedPreferencesStorage(context)
    }

    @Provides
    @Singleton
    fun provideNameManager(storage:SharedPreferencesStorage,mainComponent:MainComponent.Factory):NameManager{
        return NameManager(storage,mainComponent)
    }

    @Provides
    @Singleton
    fun provideModelAdapter():ModelAdapter{
        return ModelAdapter()
    }

    @Provides
    @Singleton
    fun provideManager(context:Context):GridLayoutManager{
        return GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
    }




}
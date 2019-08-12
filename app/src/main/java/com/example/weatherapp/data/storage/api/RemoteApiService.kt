package com.example.weatherapp.data.storage.api

import com.example.weatherapp.ui.story.splash.model.WeatherForecast
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class RemoteApiService @Inject
constructor(private val mRetrofit: Retrofit, private val mRemoteApiHelper: RemoteApiHelper) {
    fun weatherForecast(key: String, city: String, days: Int): Observable<WeatherForecast> {
        return mRemoteApiHelper.forecastWeather(key, city, days)
    }
}
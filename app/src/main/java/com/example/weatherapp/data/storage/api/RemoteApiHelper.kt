package com.example.weatherapp.data.storage.api

import com.example.weatherapp.ui.story.splash.model.WeatherForecast
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiHelper {

    @GET("/v1/forecast.json/")
    fun forecastWeather(@Query("key") key: String, @Query("q") city: String, @Query("days") days: Int): Observable<WeatherForecast>
}
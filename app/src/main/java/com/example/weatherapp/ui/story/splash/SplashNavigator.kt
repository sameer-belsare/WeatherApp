package com.example.weatherapp.ui.story.splash

import com.example.weatherapp.ui.base.BaseNavigator
import com.example.weatherapp.ui.story.splash.model.WeatherForecast

interface SplashNavigator : BaseNavigator {

    fun success(weatherForecast: WeatherForecast)

    fun failure()
}
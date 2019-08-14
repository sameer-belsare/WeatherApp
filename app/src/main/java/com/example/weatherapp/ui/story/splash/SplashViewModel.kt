package com.example.weatherapp.ui.story.splash.model

import com.example.weatherapp.data.manager.DataManager
import com.example.weatherapp.rx.SchedulerProvider
import com.example.weatherapp.ui.base.BaseViewModel
import com.example.weatherapp.ui.story.splash.SplashNavigator
import com.example.weatherapp.utils.Constants

class SplashViewModel
    (dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<SplashNavigator>(dataManager, schedulerProvider) {

    fun weatherForecast() {
        val weatherDisposable = dataManager
            .remoteApiService
            .weatherForecast(Constants.WEATHER_API_KEY, "Pune", 4)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(
                { weatherForecast ->
                    navigator?.success(weatherForecast)
                },
                { throwable ->
                    navigator?.failure()
                }
            )
        compositDisposable.add(weatherDisposable)
    }

}
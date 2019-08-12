package com.example.weatherapp.ui.story.weather

import com.example.weatherapp.data.manager.DataManager
import com.example.weatherapp.rx.SchedulerProvider
import com.example.weatherapp.ui.base.BaseViewModel

class WeatherViewModel
    (dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<WeatherNavigator>(dataManager, schedulerProvider)
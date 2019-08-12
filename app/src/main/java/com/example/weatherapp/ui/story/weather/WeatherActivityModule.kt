package com.example.weatherapp.ui.story.weather

import com.example.weatherapp.data.manager.DataManager
import com.example.weatherapp.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class WeatherActivityModule {
    @Provides
    internal fun provideWeatherViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): WeatherViewModel {
        return WeatherViewModel(dataManager, schedulerProvider)
    }
}
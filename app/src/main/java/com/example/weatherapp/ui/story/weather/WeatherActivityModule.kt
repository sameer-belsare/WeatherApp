package com.example.weatherapp.ui.story.weather

import android.content.Context
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

    @Provides
    internal fun provideWeatherAdapter(context: Context): WeatherAdapter {
        return WeatherAdapter(context)
    }
}
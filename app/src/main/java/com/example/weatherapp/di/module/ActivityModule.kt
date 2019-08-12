package com.example.weatherapp.di.module

import com.example.weatherapp.ui.story.Failure.FailureActivity
import com.example.weatherapp.ui.story.Failure.FailureActivityModule
import com.example.weatherapp.ui.story.splash.SplashActivity
import com.example.weatherapp.ui.story.splash.SplashActivityModule
import com.example.weatherapp.ui.story.weather.WeatherActivity
import com.example.weatherapp.ui.story.weather.WeatherActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [WeatherActivityModule::class])
    internal abstract fun bindWeatherActivity(): WeatherActivity

    @ContributesAndroidInjector(modules = [FailureActivityModule::class])
    internal abstract fun bindFailureActivity(): FailureActivity
}
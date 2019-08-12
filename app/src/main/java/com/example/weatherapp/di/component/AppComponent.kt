package com.example.weatherapp.di.component

import android.app.Application
import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.di.module.ActivityModule
import com.example.weatherapp.di.module.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, DataModule::class])
interface AppComponent: AndroidInjector<WeatherApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
package com.example.weatherapp.ui.story.splash

import com.example.weatherapp.data.manager.DataManager
import com.example.weatherapp.rx.SchedulerProvider
import com.example.weatherapp.ui.story.splash.model.SplashViewModel
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {
    @Provides
    internal fun provideSplashViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): SplashViewModel {
        return SplashViewModel(dataManager, schedulerProvider)
    }
}
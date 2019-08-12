package com.example.weatherapp.ui.story.Failure

import com.example.weatherapp.data.manager.DataManager
import com.example.weatherapp.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class FailureActivityModule {
    @Provides
    internal fun provideFailureViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): FailureViewModel {
        return FailureViewModel(dataManager, schedulerProvider)
    }
}
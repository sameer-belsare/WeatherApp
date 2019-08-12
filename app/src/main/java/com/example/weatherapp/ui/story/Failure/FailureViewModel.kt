package com.example.weatherapp.ui.story.Failure

import com.example.weatherapp.data.manager.DataManager
import com.example.weatherapp.rx.SchedulerProvider
import com.example.weatherapp.ui.base.BaseViewModel

class FailureViewModel
    (dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<FailureNavigator>(dataManager, schedulerProvider)
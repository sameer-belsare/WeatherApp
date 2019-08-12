package com.example.weatherapp.ui.base

import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.manager.DataManager
import com.example.weatherapp.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel<N>(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider
) : ViewModel() {
    open var navigator: N? = null
    val compositDisposable: CompositeDisposable

    init {
        this.compositDisposable = CompositeDisposable()
    }

    override fun onCleared() {
        compositDisposable.clear()
        super.onCleared()
    }
}
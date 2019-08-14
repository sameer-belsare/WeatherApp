package com.example.weatherapp.ui.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity<V : BaseViewModel<*>> : AppCompatActivity() {
    private val mViewModel: V? = null

    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
    }

    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }
}
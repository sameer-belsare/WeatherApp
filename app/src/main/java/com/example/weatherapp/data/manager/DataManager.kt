package com.example.weatherapp.data.manager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.data.storage.api.RemoteApiService
import retrofit2.Retrofit

interface DataManager {
    /** Returns an [Context] of [AppCompatActivity].  */
    val context: Context

    /** Returns an [RemoteApiService] of [Retrofit].  */
    val remoteApiService: RemoteApiService
}
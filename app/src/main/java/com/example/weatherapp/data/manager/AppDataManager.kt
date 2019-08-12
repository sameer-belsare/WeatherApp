package com.example.weatherapp.data.manager

import android.content.Context
import com.example.weatherapp.data.storage.api.RemoteApiService
import javax.inject.Inject

class AppDataManager @Inject
constructor(override val context: Context, override val remoteApiService: RemoteApiService) : DataManager
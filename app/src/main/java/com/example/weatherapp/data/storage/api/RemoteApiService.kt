package com.example.weatherapp.data.storage.api

import retrofit2.Retrofit
import javax.inject.Inject

class RemoteApiService @Inject
constructor(private val mRetrofit: Retrofit, private val mRemoteApiHelper: RemoteApiHelper) {

}
package com.example.weatherapp.di.module

import android.app.Application
import android.content.Context
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.manager.AppDataManager
import com.example.weatherapp.data.manager.DataManager
import com.example.weatherapp.data.storage.api.RemoteApiHelper
import com.example.weatherapp.data.storage.api.RemoteApiService
import com.example.weatherapp.rx.AppSchedulerProvider
import com.example.weatherapp.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideHttpCache(application: Application): Cache {
        val cacheSize = BuildConfig.CACHE_SIZE
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesRemoteApiHelper(
        retrofit: Retrofit
    ): RemoteApiHelper {
        return retrofit.create(RemoteApiHelper::class.java!!)
    }

    @Provides
    @Singleton
    internal fun provideRemoteApiService(retrofit: Retrofit, remoteApiHelper: RemoteApiHelper): RemoteApiService {
        return RemoteApiService(retrofit, remoteApiHelper)
    }
}
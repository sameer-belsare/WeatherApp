package com.example.weatherapp.ui.story.splash.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherForecast(
    var location: Location?,
    var current: Current?,
    var forecast: Forecast?
) : Parcelable

@Parcelize
data class Location(
    var name: String?, var region: String?, var country: String?, var lat: Float?, var lon: Float?,
    var tz_id: String, var localtime_epoch: Long?, var localtime: String?
) : Parcelable

@Parcelize
data class Current(
    var last_updated_epoch: Long?,
    var last_updated: String?,
    var temp_c: Float?,
    var temp_f: Float?,
    var is_day: Int?,
    var condition: Condition?,
    var wind_mph: Float?,
    var wind_kph: Float?,
    var wind_degree: Int?,
    var wind_dir: String?,
    var pressure_mb: Float?,
    var pressure_in: Float?,
    var precip_mm: Float?,
    var precip_in: Float?,
    var humidity: Int?,
    var cloud: Int?,
    var feelslike_c: Float?,
    var feelslike_f: Float?,
    var vis_km: Float?,
    var vis_miles: Float?,
    var uv: Float?,
    var gust_mph: Float?,
    var gust_kph: Float?
) : Parcelable

@Parcelize
data class Forecast(var forecastday: ArrayList<ForecastDay>) : Parcelable

@Parcelize
data class ForecastDay(var date: String?, var date_epoch: Long?, var day: Day?, var astro: Astro?) :
    Parcelable

@Parcelize
data class Day(
    var maxtemp_c: Float?,
    var maxtemp_f: Float?,
    var mintemp_c: Float?,
    var mintemp_f: Float?,
    var avgtemp_c: Float?,
    var avgtemp_f: Float?,
    var maxwind_mph: Float?,
    var maxwind_kph: Float?,
    var totalprecip_mm: Float?,
    var totalprecip_in: Float?,
    var avgvis_km: Float?,
    var avgvis_miles: Float?,
    var avghumidity: Float?,
    var condition: Condition?,
    var uv: Float?
) : Parcelable

@Parcelize
data class Astro(
    var sunrise: String?,
    var sunset: String?,
    var moonrise: String?,
    var moonset: String?
) : Parcelable

@Parcelize
data class Condition(var text: String?, var icon: String?, var code: Int?) : Parcelable
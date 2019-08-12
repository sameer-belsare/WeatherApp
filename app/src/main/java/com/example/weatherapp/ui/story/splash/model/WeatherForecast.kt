package com.example.weatherapp.ui.story.splash.model

data class WeatherForecast(val location: Location?, val current: Current?, val forecast: Forecast?)

data class Location(val name: String?, val region: String?, val country: String?, val lat: Long?, val lon: Long?,
                    val tz_id: String, val localtime_epoch: Long?, val localtime: Long?)

data class Current(val last_updated_epoch: Long?, val last_updated: Long?, val temp_c: Float?, val temp_f: Float?,
                   val is_day: Int?, val condition: Condition?, val wind_mph: Float?, val wind_kph: Float?,
                   val wind_degree: Int?, val wind_dir: String?, val pressure_mb: Float?, val pressure_in: Float?,
                   val precip_mm: Float?, val precip_in: Float?, val humidity: Int?, val cloud: Int?,
                   val feelslike_c: Float?, val feelslike_f: Float?, val vis_km: Float?, val vis_miles: Float?,
                   val uv: Float?, val gust_mph: Float?, val gust_kph: Float?)

data class Forecast(val forecastday: ArrayList<Forecastday>)

data class Forecastday(val date: String?, val date_epoch: Long?, val day: Day?, val astro: Astro?)

data class Day(val maxtemp_c: Float?, val maxtemp_f: Float?, val mintemp_c: Float?, val mintemp_f: Float?,
               val avgtemp_c: Float?, val avgtemp_f: Float?, val maxwind_mph: Float?, val maxwind_kph: Float?,
               val totalprecip_mm: Float?, val totalprecip_in: Float?, val avgvis_km: Float?, val avgvis_miles: Float?,
               val avghumidity: Float?, val condition: Condition?, val uv: Float?)

data class Astro(val sunrise: String?, val sunset: String?, val moonrise: String?, val moonset: String?)

data class Condition(val text: String?, val icon: String?, val code: Int?)
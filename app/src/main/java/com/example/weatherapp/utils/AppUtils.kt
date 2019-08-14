package com.example.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

object AppUtils {
    fun getDayFromEpoch(epoch: Long?): String {

        val simpleDateFormat = SimpleDateFormat("EEEE", Locale.ENGLISH)
        simpleDateFormat.timeZone = TimeZone.getDefault()
        val date = Date(epoch!!*1000L)
        return simpleDateFormat.format(date)

        /*val calendar = Calendar.getInstance()
        calendar.time = date
        //return calendar.get(Calendar.DAY_OF_WEEK).toString()*/
    }
}
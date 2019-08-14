package com.example.weatherapp.ui.story.weather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.ui.base.BaseViewHolder
import com.example.weatherapp.ui.story.splash.model.ForecastDay
import com.example.weatherapp.utils.AppUtils
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.weather_item_view.*

class WeatherAdapter
    (private val mContext: Context) : RecyclerView.Adapter<BaseViewHolder>() {

    private var mForecastDayList: ArrayList<ForecastDay>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val activityView =
            LayoutInflater.from(parent.context).inflate(R.layout.weather_item_view, parent, false)
        return WeatherViewHolder(activityView, activityView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.itemView.tag = position
        holder.onBind(position)
    }

    override fun getItemCount() = mForecastDayList!!.size

    fun addForecast(forecastDayList: ArrayList<ForecastDay>?) {
        mForecastDayList = forecastDayList
    }

    inner class WeatherViewHolder(forecastView: View, override val containerView: View?) :
        BaseViewHolder(forecastView), LayoutContainer {

        override fun onBind(position: Int) {

            val forecastDay = mForecastDayList!![position]
            tvDay.text = AppUtils.getDayFromEpoch(forecastDay.date_epoch)
            tvTemp.text = forecastDay.day?.avgtemp_c.toString() + 0x00B0.toChar() + "C"
        }
    }
}
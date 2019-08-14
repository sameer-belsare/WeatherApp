package com.example.weatherapp.ui.story.weather

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.ui.base.BaseActivity
import com.example.weatherapp.ui.story.splash.model.WeatherForecast
import kotlinx.android.synthetic.main.activity_weather.*
import javax.inject.Inject


class WeatherActivity : BaseActivity<WeatherViewModel>(), WeatherNavigator {

    @Inject
    override lateinit var viewModel: WeatherViewModel

    @Inject
    lateinit var mWeatherAdapter: WeatherAdapter

    private val ANIMATION_DURATION: Long = 750

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        viewModel.navigator = this
        setupViews()
    }

    override fun setupViews() {
        val weatherForecast = intent.getParcelableExtra("weatherjson") as WeatherForecast

        tvTitleTemp.text = weatherForecast.current?.temp_c.toString() + 0x00B0.toChar()
        tvCity.text = weatherForecast.location?.name

        weatherRecyclerView.visibility = View.GONE
        weatherRecyclerView.layoutManager = LinearLayoutManager(this)
        mWeatherAdapter.addForecast(weatherForecast.forecast?.forecastday)
        weatherRecyclerView.adapter = mWeatherAdapter

        Handler().postDelayed(Runnable {
            val selectedViewY = bottomLayout.y
            val animator =
                ObjectAnimator.ofFloat(weatherRecyclerView, "translationY", selectedViewY, 0f)
            animator.duration = ANIMATION_DURATION
            val set = AnimatorSet()
            set.play(animator)
            weatherRecyclerView.visibility = View.VISIBLE
            set.start()
        }, 1000)
    }
}

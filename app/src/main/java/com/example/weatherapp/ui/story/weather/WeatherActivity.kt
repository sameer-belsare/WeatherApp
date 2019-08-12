package com.example.weatherapp.ui.story.weather

import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_weather.*
import javax.inject.Inject

class WeatherActivity : BaseActivity<WeatherViewModel>(), WeatherNavigator {

    @Inject
    override lateinit var viewModel: WeatherViewModel

    @Inject
    lateinit var mWeatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        viewModel!!.navigator = this
        setupViews()
    }

    override fun setupViews() {
        weatherRecyclerView.layoutManager = LinearLayoutManager(this)


    }
}

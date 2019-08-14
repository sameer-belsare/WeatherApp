package com.example.weatherapp.ui.story.splash

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import com.example.weatherapp.R
import com.example.weatherapp.ui.base.BaseActivity
import com.example.weatherapp.ui.story.Failure.FailureActivity
import com.example.weatherapp.ui.story.splash.model.SplashViewModel
import com.example.weatherapp.ui.story.splash.model.WeatherForecast
import com.example.weatherapp.ui.story.weather.WeatherActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashViewModel>(), SplashNavigator {
    private val ANIMATION_DURATION: Long = 1000
    @Inject
    override lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        viewModel.navigator = this
        setupViews()
        viewModel.weatherForecast()
    }

    override fun setupViews() {
        val imageViewObjectAnimator = ObjectAnimator.ofFloat(
            ivLoading,
            "rotation", 0f, 360f
        )
        imageViewObjectAnimator.repeatCount = ValueAnimator.INFINITE
        imageViewObjectAnimator.duration = ANIMATION_DURATION
        imageViewObjectAnimator.start()
    }

    override fun success(weatherForecast: WeatherForecast) {
        finish()
        val intent = Intent(this, WeatherActivity::class.java)
        intent.putExtra("weatherjson", weatherForecast)
        startActivity(intent)
    }

    override fun failure() {
        finish()
        startActivity(Intent(this, FailureActivity::class.java))
    }
}
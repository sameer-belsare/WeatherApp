package com.example.weatherapp.ui.story.Failure

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import com.example.weatherapp.R
import com.example.weatherapp.ui.base.BaseActivity
import com.example.weatherapp.ui.story.splash.SplashActivity
import kotlinx.android.synthetic.main.activity_failure.*
import javax.inject.Inject

class FailureActivity : BaseActivity<FailureViewModel>(), FailureNavigator {

    @Inject
    override lateinit var viewModel: FailureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_failure)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        viewModel.navigator = this
        setupViews()
    }

    override fun setupViews() {
        btnRetry.setOnClickListener {
            finish()
            startActivity(Intent(this, SplashActivity::class.java))
        }
    }
}
package com.example.weatherapp.ui.story.Failure

import android.os.Bundle
import android.view.WindowManager
import com.example.weatherapp.R
import com.example.weatherapp.ui.base.BaseActivity
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
    }

    override fun setupViews() {

    }

}
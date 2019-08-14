package com.example.weatherapp

import androidx.test.rule.ActivityTestRule
import com.example.weatherapp.ui.story.splash.SplashActivity
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

class SplashActivityTest {

    @Rule
    var mSplashActivityTestRule = ActivityTestRule(SplashActivity::class.java)

    @Test
    fun testViewShouldDisplayed() {
        onView(withId(R.id.ivLoading)).check(matches(isDisplayed()))
    }
}
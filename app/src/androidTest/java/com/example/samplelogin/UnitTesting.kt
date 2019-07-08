package com.example.samplelogin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.samplelogin.ui.MainActivity
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class UnitTesting {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginSuccess() {
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("nicole")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("qwerty")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        // if one of the buttons in the activity is found, login is successful
        Thread.sleep(2000)
        onView(withId(R.id.activity_main_menu))
            .check(matches(withChild(withId(R.id.my_work_button))))
    }

    @Test
    fun loginFailure() {
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("a23rasdf")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("asdfzx34")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        // if one of the buttons in the activity is found, login is successful
        Thread.sleep(2000)
        onView(withText("Username or password is incorrect."))
            .inRoot(withDecorView(not(`is`(activityRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }
}

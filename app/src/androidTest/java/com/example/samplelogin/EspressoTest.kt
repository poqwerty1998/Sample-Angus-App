package com.example.samplelogin

import android.service.autofill.Validators.not
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.samplelogin.mainmenu.MainMenuActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HelloWorldEspressoTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginSuccess() {
        onView(withId(R.id.username)).perform((typeText("admin")), closeSoftKeyboard())
        onView(withId(R.id.password)).perform((typeText("admin")), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        onView(withText("Login success!")).check(matches(isDisplayed()))
    }

    /*@Test
    fun loginFailure_showToast() {
        onView(withId(R.id.username)).perform((typeText("")), closeSoftKeyboard())
        onView(withId(R.id.password)).perform((typeText("")), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        onView(withText("Username or password is incorrect."))
            .inRoot(withDecorView(not(MainMenuActivity.getActivity())))
            .check(matches(isDisplayed()));
    }*/
}
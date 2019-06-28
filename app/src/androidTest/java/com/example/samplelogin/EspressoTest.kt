package com.example.samplelogin

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.samplelogin.ui.MainActivity
import com.example.samplelogin.ui.mainmenu.MainMenuActivity
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
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("admin")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("admin")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        // checking the views in the activity
        onView(withId(R.id.activity_main_menu))
            .check(matches(withChild(withId(R.id.my_work_button))))
        onView(withId(R.id.activity_main_menu))
            .check(matches(withChild(withId(R.id.search_button))))
        onView(withId(R.id.activity_main_menu))
            .check(matches(withChild(withId(R.id.create_button))))
        onView(withId(R.id.activity_main_menu))
            .check(matches(withChild(withId(R.id.overview_button))))
        // press back
        onView(withId(R.id.activity_main_menu))
            .perform(pressBack())
        onView(withId(R.id.activity_main))
            .check(matches(withChild(withId(R.id.loginButton))))
    }
}
package com.example.sampleangusapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.sampleangusapp.ui.MainActivity
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class UITesting {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainMenuTest() {
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("nicole")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("qwerty")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        Thread.sleep(2000)
        // if one of the buttons in the activity is found, login is successful
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

    @Test
    fun myWorkModuleTest() {
        onView(withId(R.id.username))
            .perform((typeText("nicole")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("qwerty")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        Thread.sleep(2000)

        onView(withId(R.id.my_work_button))
            .perform(click())
        onView(withId(R.id.tenantRequestRecyclerView))
            .perform(click())
    }

    @Test
    fun overviewModuleTest() {
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("nicole")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("qwerty")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        Thread.sleep(2000)

        onView(withId(R.id.overview_button))
            .perform(click())
        onView(withId(R.id.activity_overview))
            .check(matches(withChild(withId(R.id.overview_tr_button))))
        onView(withId(R.id.activity_overview))
            .check(matches(withChild(withId(R.id.overview_emergency_button))))
    }

    @Test
    fun createModuleTest() {
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("nicole")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("qwerty")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        Thread.sleep(2000)

        onView(withId(R.id.create_button))
            .perform(click())
        onView(withId(R.id.activity_create))
            .check(matches(withChild(withId(R.id.create_work_order_button))))
        onView(withId(R.id.activity_create))
            .check(matches(withChild(withId(R.id.create_notifications_button))))
    }

    @Test
    fun searchModuleTest() {
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("nicole")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("qwerty")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        Thread.sleep(2000)

        onView(withId(R.id.search_button))
            .perform(click())
        onView(withId(R.id.activity_search))
            .check(matches(withChild(withId(R.id.search_work_orders_button))))
        onView(withId(R.id.activity_search))
            .check(matches(withChild(withId(R.id.search_directory_button))))
    }
    @Test
    fun loginSuccessTest() {
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
    fun loginFailureTest() {
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("username")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("password")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        // if one of the buttons in the activity is found, login is successful
        Thread.sleep(2000)
        onView(withText("Username or password is incorrect."))
            .inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

}
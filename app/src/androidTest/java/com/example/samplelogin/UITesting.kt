package com.example.samplelogin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.samplelogin.ui.MainActivity
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
    fun fourModulesTest() {
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("nicole")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("qwerty")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        Thread.sleep(2000)

        /*// my work module
        onView(withId(R.id.my_work_button))
            .perform(click())
        onView(withId(R.id.activity_my_work))
            .check(matches(withChild(withId(R.id.bottom_nav))))
        onView(withId(R.id.bottom_nav))
            .check(matches(withChild(withId(R.id.tenantRequestFragment))))
        onView(withId(R.id.bottom_nav))
            .check(matches(withChild(withId(R.id.preventiveMaintenanceFragment))))
        onView(withId(R.id.bottom_nav))
            .check(matches(withChild(withId(R.id.inspectionsFragment))))
        onView(withId(R.id.activity_my_work))
            .perform(pressBack())*/

        // overview module
        onView(withId(R.id.overview_button))
            .perform(click())
        onView(withId(R.id.activity_overview))
            .check(matches(withChild(withId(R.id.overview_tr_button))))
        onView(withId(R.id.activity_overview))
            .check(matches(withChild(withId(R.id.overview_emergency_button))))
        onView(withId(R.id.activity_overview))
            .perform(pressBack())
        // create module
        onView(withId(R.id.create_button))
            .perform(click())
        onView(withId(R.id.activity_create))
            .check(matches(withChild(withId(R.id.create_work_order_button))))
        onView(withId(R.id.activity_create))
            .check(matches(withChild(withId(R.id.create_notifications_button))))
        onView(withId(R.id.activity_create))
            .perform(pressBack())
        // search module
        onView(withId(R.id.search_button))
            .perform(click())
        onView(withId(R.id.activity_search))
            .check(matches(withChild(withId(R.id.search_work_orders_button))))
        onView(withId(R.id.activity_search))
            .check(matches(withChild(withId(R.id.search_directory_button))))
        onView(withId(R.id.activity_search))
            .perform(pressBack())
    }
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
            .inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }
}
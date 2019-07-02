package com.example.samplelogin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import androidx.test.espresso.matcher.RootMatchers
import com.example.samplelogin.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class UITesting {

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
        // if one of the buttons in the activity is found, login is successful
        onView(withId(R.id.activity_main_menu))
            .check(matches(withChild(withId(R.id.my_work_button))))
    }
    @Test
    fun mainMenuTest() {
        // typing in credentials to log in
        onView(withId(R.id.username))
            .perform((typeText("admin")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("admin")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
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
            .perform((typeText("admin")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("admin")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())

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
    /*@Test
    fun loginFailure() {
        // typing credentials that will not log the user in
        onView(withId(R.id.username))
            .perform((typeText("abc")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("abc")), closeSoftKeyboard())
        onView(withId(R.id.loginButton))
            .perform(click())
        onView(withText("Username or password is incorrect.")).inRoot(ToastMatcher)
    }*/             // need to create a custom toast matcher to check for toasts
}
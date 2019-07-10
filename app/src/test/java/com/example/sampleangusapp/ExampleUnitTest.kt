package com.example.sampleangusapp

import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.junit.runner.RunWith


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleUnitTest {

    /*@get:Rule
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
    }*/
}

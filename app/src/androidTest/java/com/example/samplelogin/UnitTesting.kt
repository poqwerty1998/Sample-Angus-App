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
class UnitTesting {
    @Test
    fun loginFieldsTest() {
        onView(withId(R.id.username))
            .perform((typeText("admin")), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform((typeText("admin")), closeSoftKeyboard())
        // verifying the field to see if it matches, currently only dummy values being used so need to
        // contact database to do actual verification of login
        onView(withId(R.id.username))
            .check(matches(withText("admin")))
        onView(withId(R.id.password))
            .check(matches(withText("admin")))
    }
}
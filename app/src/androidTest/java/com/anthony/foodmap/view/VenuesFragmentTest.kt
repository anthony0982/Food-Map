package com.anthony.foodmap.view

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.anthony.foodmap.MainActivity
import com.anthony.foodmap.R
import com.anthony.foodmap.util.DataBindingIdlingResource
import com.anthony.foodmap.util.EspressoIdlingResource
import com.anthony.foodmap.util.monitorActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class VenuesFragmentTest {

    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    private val dataBindingIdlingResource = DataBindingIdlingResource()

    @Before
    fun setup() {
        dataBindingIdlingResource.activity = mActivityTestRule.activity
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
        IdlingRegistry.getInstance().register(dataBindingIdlingResource)
    }

    /**
     * Unregister your Idling Resource so it can be garbage collected and does not leak any memory.
     */
    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
        IdlingRegistry.getInstance().unregister(dataBindingIdlingResource)
    }

    @Test
    fun display() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        dataBindingIdlingResource.monitorActivity(activityScenario)


        onView(withId(R.id.venues_list)).check(matches(isDisplayed()))
    }

}
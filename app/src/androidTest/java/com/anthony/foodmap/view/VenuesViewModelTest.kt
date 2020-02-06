
package com.anthony.foodmap.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.anthony.foodmap.App
import com.anthony.foodmap.MainActivity
import com.anthony.foodmap.MainCoroutineRule
import com.anthony.foodmap.repository.VenuesRepository
import com.anthony.foodmap.viewmodel.VenuesViewModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Unit tests for the implementation of [VenuesViewModel]
 */
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@LargeTest
class VenuesViewModelTest {

    private lateinit var venuesViewModel: VenuesViewModel

    // Use a fake repository to be injected into the viewmodel
    private lateinit var venuesRepository: VenuesRepository


    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Rule @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)


    @Before
    fun setUp() {
        venuesRepository = (activityTestRule.getActivity().getApplication() as App).venuesRepository
    }

    @Before
    fun setupViewModel() {
        // We initialise the tasks to 3, with one active and two completed
        venuesViewModel = VenuesViewModel(venuesRepository)
    }

    @Test
    fun loadVenues() {
        // Pause dispatcher so we can verify initial values
        mainCoroutineRule.pauseDispatcher()


        // Trigger loading
        var center = LatLng(39.99666588175694,116.7861326225102)
        venuesViewModel.loadVenues( "39.96475304503403,116.75523374229671","40.02857769108418,116.8170315027237", center)

        // Execute pending coroutines actions
        mainCoroutineRule.resumeDispatcher()

        // And data correctly loaded
        // Truth.assertThat(LiveDataTestUtil.getValue(venuesViewModel.items)).isNotEmpty()
    }

}

package com.anthony.foodmap.util

import android.app.Activity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.test.core.app.ActivityScenario
import com.anthony.foodmap.R
import org.junit.Assert

fun <T : Activity> ActivityScenario<T>.getToolbarNavigationContentDescription()
    : String {
    var description = ""
    onActivity {
        description =
            it.findViewById<Toolbar>(R.id.toolbar).navigationContentDescription as String
    }
    return description
}

fun assertLiveDataEventTriggered(
        liveData: LiveData<Event<String>>,
        taskId: String
) {
    val value = LiveDataTestUtil.getValue(liveData)
    Assert.assertEquals(value.getContentIfNotHandled(), taskId)
}

fun assertSnackbarMessage(snackbarLiveData: LiveData<Event<Int>>, messageId: Int) {
    val value: Event<Int> = LiveDataTestUtil.getValue(snackbarLiveData)
    Assert.assertEquals(value.getContentIfNotHandled(), messageId)
}
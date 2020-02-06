package com.anthony.foodmap.util

/**
 * Extension functions for Fragment.
 */

import android.app.Activity
import androidx.fragment.app.Fragment
import com.anthony.foodmap.App
import com.anthony.foodmap.viewmodel.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as App).venuesRepository
    return ViewModelFactory(repository)
}

fun Activity.getViewModelFactory(): ViewModelFactory {
    val repository = (applicationContext as App).venuesRepository
    return ViewModelFactory(repository)
}

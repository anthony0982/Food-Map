package com.anthony.foodmap

import android.os.Bundle
import com.anthony.foodmap.view.MapFragment
import com.anthony.foodmap.view.VenuesFragment
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(findViewById(R.id.toolbar))
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.map_container, MapFragment()).commit()
            supportFragmentManager.beginTransaction().replace(R.id.venues_container, VenuesFragment()).commit()
        }
    }

}
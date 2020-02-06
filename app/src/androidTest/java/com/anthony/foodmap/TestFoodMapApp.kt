package com.anthony.foodmap
import com.anthony.foodmap.di.components.DaggerFoodMapComponent

class TestFoodMapApp: App() {
    override fun onCreate() {
        super.onCreate()
        initDagger()
    }
    fun initDagger() {
        DaggerFoodMapComponent.builder().build().inject(this)
    }
}
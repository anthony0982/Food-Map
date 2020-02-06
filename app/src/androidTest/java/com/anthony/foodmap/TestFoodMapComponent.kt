package com.anthony.foodmap

import com.anthony.foodmap.di.builders.ActivityBuilder
import com.anthony.foodmap.di.components.FoodMapComponent
import com.anthony.foodmap.di.modules.FoodMapAppModule
import com.anthony.foodmap.di.modules.NetworkModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, FoodMapAppModule::class, NetworkModule::class, ActivityBuilder::class])
interface TestFoodMapComponent : FoodMapComponent {
}
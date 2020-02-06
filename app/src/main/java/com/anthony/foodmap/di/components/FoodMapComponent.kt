package com.anthony.foodmap.di.components

import com.anthony.foodmap.App
import com.anthony.foodmap.di.builders.ActivityBuilder
import com.anthony.foodmap.di.modules.FoodMapAppModule
import com.anthony.foodmap.di.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, FoodMapAppModule::class, NetworkModule::class, ActivityBuilder::class])
interface FoodMapComponent : AndroidInjector<App?> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App?>()
}
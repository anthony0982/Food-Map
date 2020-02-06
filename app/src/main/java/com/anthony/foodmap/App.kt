package com.anthony.foodmap

import android.content.Context
import androidx.multidex.MultiDex
import androidx.room.Room
import com.anthony.foodmap.di.components.DaggerFoodMapComponent
import com.anthony.foodmap.repository.VenuesRepository
import com.anthony.foodmap.repository.db.AppDatabase
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject

open class App : DaggerApplication() {
    companion object {
        private lateinit var appDatabase: AppDatabase
    }

    @Inject
    lateinit var venuesRepository: VenuesRepository


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
        appDatabase = Room.databaseBuilder(applicationContext,
                AppDatabase::class.java, "food-map").build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication?> {
        return DaggerFoodMapComponent.builder().create(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
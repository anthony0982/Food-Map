package com.anthony.foodmap.di.modules

import android.content.Context
import com.anthony.foodmap.App
import com.anthony.foodmap.util.Utils
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FoodMapAppModule {
    @Singleton
    @Provides
    fun provideContext(app: App): Context {
        return app
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideUtils(context: Context?): Utils {
        return Utils(context)
    }
}
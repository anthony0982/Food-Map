package com.anthony.foodmap.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.olu.mvvm.repository.data.Venue


@Database(entities = arrayOf(Venue::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
}
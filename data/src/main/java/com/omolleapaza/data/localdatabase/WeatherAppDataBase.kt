package com.omolleapaza.data.localdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omolleapaza.data.localdatabase.dao.LocationDao
import com.omolleapaza.data.localdatabase.dao.SaveSearchHistoryDao
import com.omolleapaza.data.localdatabase.entity.LocationEntity
import com.omolleapaza.data.localdatabase.entity.SearchHistoryEntity


@Database(
    entities = [
        LocationEntity::class,
        SearchHistoryEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class WeatherAppDataBase : RoomDatabase() {

    abstract fun locationDao(): LocationDao

    abstract fun saveSearchHistoryDao(): SaveSearchHistoryDao

}
package com.omolleapaza.data.di

import android.app.Application
import androidx.room.Room
import com.omolleapaza.data.localdatabase.WeatherAppDataBase
import com.omolleapaza.data.localdatabase.dao.LocationDao
import com.omolleapaza.data.localdatabase.dao.SaveSearchHistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDataBase(
        application: Application,
    ): WeatherAppDataBase {
        return Room.databaseBuilder(
            application,
            WeatherAppDataBase::class.java,
            "Weather.db",
        ).build()
    }

    @Provides
    @Singleton
    fun providesLocationDao(weatherDataBase: WeatherAppDataBase): LocationDao {
        return weatherDataBase.locationDao()
    }

    @Provides
    @Singleton
    fun providesSaveSearchHistoryDao(weatherDataBase: WeatherAppDataBase): SaveSearchHistoryDao {
        return weatherDataBase.saveSearchHistoryDao()
    }
}

package com.omolleapaza.data.di

import com.omolleapaza.data.repository.WeatherPostRepositoryImpl
import com.omolleapaza.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindWeatherRepository(weatherPostRepositoryImpl: WeatherPostRepositoryImpl): WeatherRepository
}

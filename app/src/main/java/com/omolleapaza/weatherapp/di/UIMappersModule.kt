package com.omolleapaza.weatherapp.di

import com.omolleapaza.weatherapp.mapper.LocationUIMapper
import com.omolleapaza.weatherapp.mapper.LocationUIMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UIMappersModule {

    @Binds
    abstract fun bindMovieUIMapper(
        locationUIMapperImpl: LocationUIMapperImpl,
    ): LocationUIMapper
}

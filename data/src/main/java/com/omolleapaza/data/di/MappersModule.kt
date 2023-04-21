package com.omolleapaza.data.di

import com.omolleapaza.data.mapper.WeatherMapper
import com.omolleapaza.data.mapper.WeatherMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersModule {

    @Binds
    abstract fun bindWeatherDataMapper(weatherMapperImpl: WeatherMapperImpl): WeatherMapper
}

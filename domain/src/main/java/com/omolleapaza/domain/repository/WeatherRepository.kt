package com.omolleapaza.domain.repository

import com.omolleapaza.core.Result
import com.omolleapaza.domain.entities.LocationModel
import com.omolleapaza.domain.entities.WeatherModel
import kotlinx.coroutines.flow.Flow


interface WeatherRepository {

    suspend fun getWeather(latitude: Double, longitude: Double): Flow<Result<WeatherModel>>

    suspend fun insertLocation(location: LocationModel)

    suspend fun getLocations(): Flow<Result<List<LocationModel>>>

}
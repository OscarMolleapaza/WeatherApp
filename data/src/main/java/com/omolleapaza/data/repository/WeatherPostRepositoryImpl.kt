package com.omolleapaza.data.repository

import com.omolleapaza.core.Result
import com.omolleapaza.core.Failure
import com.omolleapaza.core.mapper
import com.omolleapaza.data.datasource.local.LocalWeatherDataSource
import com.omolleapaza.data.datasource.remote.RemoteWeatherDataSource
import com.omolleapaza.data.mapper.WeatherMapper
import com.omolleapaza.domain.entities.LocationModel
import com.omolleapaza.domain.entities.WeatherModel
import com.omolleapaza.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class WeatherPostRepositoryImpl @Inject constructor(
    private val remoteDs: RemoteWeatherDataSource,
    private val localDs: LocalWeatherDataSource,
    private val weatherMapper: WeatherMapper
) : WeatherRepository {
    override suspend fun getWeather(
        latitude: Double,
        longitude: Double
    ): Flow<Result<WeatherModel>> = flow {
        when(val fetchWeather = remoteDs.getWeather(latitude = latitude,longitude = longitude)){
            is Result.Error -> emit(Result.Error(fetchWeather.failure))
            is Result.Success -> {
                val resultToDomain: Result<WeatherModel> = fetchWeather.mapper {
                    weatherMapper.mapWeatherResponseToModel(it)
                }
                emit(resultToDomain)
            }
        }
    }

    override suspend fun insertLocation(location: LocationModel) {
        localDs.insertLocation(weatherMapper.mapLocationModelToEntity(location))
    }

    override suspend fun getLocations(): Flow<Result<List<LocationModel>>> = flow {

        val fetchLocations: List<LocationModel> = weatherMapper.mapLocationEntityToModelList(localDs.getAllLocations())
        emit(Result.Success(fetchLocations))
    }


}


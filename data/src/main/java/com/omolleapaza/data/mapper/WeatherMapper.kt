package com.omolleapaza.data.mapper

import com.omolleapaza.data.api.response.WeatherResponse
import com.omolleapaza.data.localdatabase.entity.LocationEntity
import com.omolleapaza.domain.entities.LocationModel
import com.omolleapaza.domain.entities.WeatherModel


interface WeatherMapper {

    suspend fun mapWeatherResponseToModel(
            requests: WeatherResponse
    ): WeatherModel


    suspend fun mapLocationModelToEntity(
        requests: LocationModel
    ): LocationEntity

    suspend fun mapLocationEntityToModel(
        requests: LocationEntity
    ): LocationModel

    suspend fun mapLocationModelToEntityList(
        requests: List<LocationModel>
    ): List<LocationEntity>

    suspend fun mapLocationEntityToModelList(
        requests: List<LocationEntity>
    ): List<LocationModel>

}
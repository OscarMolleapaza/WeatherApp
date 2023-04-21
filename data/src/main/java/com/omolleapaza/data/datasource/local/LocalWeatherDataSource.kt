package com.omolleapaza.data.datasource.local

import com.omolleapaza.data.localdatabase.entity.LocationEntity
import com.omolleapaza.data.localdatabase.entity.SearchHistoryEntity


interface LocalWeatherDataSource {

    suspend fun getAllLocations() :  List<LocationEntity>

    suspend fun insertLocation(locationEntity: LocationEntity)

    suspend fun saveListLocations(response: List<LocationEntity>)


    suspend fun getAllSearchHistory() : List<SearchHistoryEntity>

    suspend fun saveSearchHistory(response: SearchHistoryEntity)

    suspend fun saveSearchHistorys(response: List<SearchHistoryEntity>)

}
package com.omolleapaza.data.datasource.local

import com.omolleapaza.data.localdatabase.dao.LocationDao
import com.omolleapaza.data.localdatabase.dao.SaveSearchHistoryDao
import com.omolleapaza.data.localdatabase.entity.LocationEntity
import com.omolleapaza.data.localdatabase.entity.SearchHistoryEntity
import com.omolleapaza.data.utils.safeDataBaseOperations
import javax.inject.Inject

class LocalWeatherDataSourceImpl @Inject constructor(
    private val locationDao: LocationDao,
    private val saveSearchHistoryDao: SaveSearchHistoryDao
) : LocalWeatherDataSource {
    override suspend fun getAllLocations(): List<LocationEntity> {
        return safeDataBaseOperations(emptyList()){
            locationDao.getAllLocations()
        }
    }

    override suspend fun insertLocation(locationEntity: LocationEntity) {
        return safeDataBaseOperations(Unit){
            locationDao.insert(locationEntity)
        }
    }

    override suspend fun saveListLocations(response: List<LocationEntity>) {
        return safeDataBaseOperations(Unit){
            locationDao.insertAll(response)
        }
    }

    override suspend fun getAllSearchHistory(): List<SearchHistoryEntity> {
        return safeDataBaseOperations(emptyList()){
            saveSearchHistoryDao.getAllSearchHistory()
        }
    }

    override suspend fun saveSearchHistory(response: SearchHistoryEntity) {
        return safeDataBaseOperations(Unit){
            saveSearchHistoryDao.insert(response)
        }
    }

    override suspend fun saveSearchHistorys(response: List<SearchHistoryEntity>) {
        return safeDataBaseOperations(Unit){
            saveSearchHistoryDao.insertAll(response)
        }
    }


}

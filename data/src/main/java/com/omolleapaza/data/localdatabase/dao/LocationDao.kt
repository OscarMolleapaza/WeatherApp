package com.omolleapaza.data.localdatabase.dao

import androidx.room.*
import com.omolleapaza.data.localdatabase.entity.LocationEntity


@Dao
interface LocationDao {

    @Query("SELECT * from location")
    suspend fun getAllLocations(): List<LocationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: LocationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<LocationEntity>)

    @Delete
    suspend fun deleteItem(data: LocationEntity)
}
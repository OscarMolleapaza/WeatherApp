package com.omolleapaza.data.localdatabase.dao

import androidx.room.*
import com.omolleapaza.data.localdatabase.entity.LocationEntity
import com.omolleapaza.data.localdatabase.entity.SearchHistoryEntity


@Dao
interface SaveSearchHistoryDao  {

    @Query("SELECT * from search_history ORDER BY time DESC")
    suspend fun getAllSearchHistory(): List<SearchHistoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: SearchHistoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<SearchHistoryEntity>)

    @Delete
    suspend fun deleteItem(data: SearchHistoryEntity)

}
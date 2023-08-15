package com.example.compose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ConvertedDao {
    @Insert
    suspend fun insertResult(result:ConversionResult)
    @Delete
    suspend fun deleteResult(result: ConversionResult)
    @Query("delete from result_table")
    suspend fun deleteAll()

    @Query("SELECT * from result_table")
    fun getResult(): Flow<List<ConversionResult>>
}
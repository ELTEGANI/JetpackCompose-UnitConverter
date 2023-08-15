package com.example.compose.data
import kotlinx.coroutines.flow.Flow

interface  ConvertorRepository {
    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAllResult()
    fun getSavedResult(): Flow<List<ConversionResult>>
}
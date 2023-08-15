package com.example.compose.data

import kotlinx.coroutines.flow.Flow

class ConvertedRepositoryIml(private val convertedDao: ConvertedDao) : ConvertorRepository {
    override suspend fun insertResult(result: ConversionResult) {
        convertedDao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        convertedDao.deleteResult(result)
    }

    override suspend fun deleteAllResult() {
        convertedDao.deleteAll()
    }

    override fun getSavedResult(): Flow<List<ConversionResult>> {
        return convertedDao.getResult()
    }
}
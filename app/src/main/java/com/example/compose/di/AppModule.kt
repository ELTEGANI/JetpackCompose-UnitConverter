package com.example.compose.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.compose.data.ConvertedRepositoryIml
import com.example.compose.data.ConverterDatabase
import com.example.compose.data.ConvertorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideConvertorDB(application: Application):ConverterDatabase{
       return Room.databaseBuilder(
           application,
           ConverterDatabase::class.java,
           "converter_data_database"
       ).build()
    }
    @Provides
    @Singleton
    fun provideConvertRepository(converterDatabase: ConverterDatabase):ConvertorRepository{
       return ConvertedRepositoryIml(converterDatabase.converterDAO)
    }
}
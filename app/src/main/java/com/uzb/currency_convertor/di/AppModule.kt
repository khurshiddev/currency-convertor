package com.uzb.currency_convertor.di

import com.uzb.currency_convertor.data.ConvertorApi
import com.uzb.currency_convertor.main.MainRepository
import com.uzb.currency_convertor.main.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getConverterApi():ConvertorApi {
        return  Retrofit
            .Builder()
            .baseUrl("https://api.apilayer.com/currency_data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConvertorApi::class.java)
    }


    @Singleton
    @Provides
    fun getMainRepository(api:ConvertorApi):MainRepository = MainRepositoryImpl(api)
}
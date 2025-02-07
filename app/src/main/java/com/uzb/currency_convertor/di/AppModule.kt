package com.uzb.currency_convertor.di

import com.uzb.currency_convertor.data.ConvertorApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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
            .build().create(ConvertorApi::class.java)
    }
}
package com.uzb.currency_convertor.main

import com.uzb.currency_convertor.data.ConvertorApi
import com.uzb.currency_convertor.data.models.ExchangeResponse
import com.uzb.currency_convertor.utils.Resource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: ConvertorApi
) : MainRepository {
    override suspend fun convertRate(
        from: String,
        to: String,
        amount: String
    ): Resource<ExchangeResponse> {
       return try {
            val response = api.convertRate(from, to, amount)
           if(response.isSuccessful && response.body() != null){
               Resource.Success(response.body())
           }else{
               Resource.Error(response.message())
           }
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }
}
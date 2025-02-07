package com.uzb.currency_convertor.data

import com.uzb.currency_convertor.data.models.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ConvertorApi {
    @GET("convert")
    suspend fun converRate(
        @Query("from") from:String,
        @Query("to") to:String,
        @Query("amount") amount:String
    ):Response<ExchangeResponse>

}
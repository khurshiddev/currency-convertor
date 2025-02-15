package com.uzb.currency_convertor.data

import com.uzb.currency_convertor.data.models.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ConvertorApi {
    @GET("convert")
    @Headers("apikey:z0hzYYOZgeh2nCQXlOUgViOR5Hw95ZEL")
    suspend fun convertRate(
        @Query("from") from:String,
        @Query("to") to:String,
        @Query("amount") amount:String
    ):Response<ExchangeResponse>

}
package com.uzb.currency_convertor.main

import com.uzb.currency_convertor.data.models.ExchangeResponse
import com.uzb.currency_convertor.utils.Resource

interface MainRepository {

    suspend fun convertRate(
        from:String,
        to:String,
        amount:String
    ):Resource<ExchangeResponse>
}
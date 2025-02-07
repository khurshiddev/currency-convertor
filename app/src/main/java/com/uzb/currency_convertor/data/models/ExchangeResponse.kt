package com.uzb.currency_convertor.data.models

import com.google.gson.annotations.SerializedName

data class ExchangeResponse(
    @SerializedName("data")
    val date: String,
    @SerializedName("history")
    val historical: Boolean,
    @SerializedName("info")
    val info: Info,
    @SerializedName("query")
    val query: Query,
    @SerializedName("result")
    val result: Double,
    @SerializedName("success")
    val success: Boolean
)
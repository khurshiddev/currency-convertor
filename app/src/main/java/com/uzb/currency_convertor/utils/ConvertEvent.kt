package com.uzb.currency_convertor.utils

import com.uzb.currency_convertor.data.ConvertorApi
import com.uzb.currency_convertor.data.models.ExchangeResponse

sealed class ConvertEvent{

    data class Success(val result: ExchangeResponse):ConvertEvent()
    data class Error(val errorMessage: String?):ConvertEvent()
    object Loading:ConvertEvent()
    object Empty:ConvertEvent()
}

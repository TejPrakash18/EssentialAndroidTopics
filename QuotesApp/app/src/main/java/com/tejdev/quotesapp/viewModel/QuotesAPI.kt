package com.tejdev.quotesapp.viewModel

import com.tejdev.quotesapp.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuotesAPI {
    @GET("random")
    suspend fun getQuotes(): Response<List<QuoteModel>>
}
package com.definex.androidwork.api

import com.definex.androidwork.model.ProductApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.PRODUCTS)
    suspend fun getProducts(): Response<ProductApiResponse>

}
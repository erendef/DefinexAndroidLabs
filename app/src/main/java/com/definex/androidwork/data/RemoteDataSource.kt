package com.definex.androidwork.data

import com.definex.androidwork.api.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getProducts() = apiService.getProducts()
}
package com.definex.androidwork.api

import retrofit2.Response

abstract class BaseApiResponse {
    suspend fun <T> apiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: java.lang.Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): NetworkResult<T> {
        return NetworkResult.Error("Call failed $errorMessage")
    }
}
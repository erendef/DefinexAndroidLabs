package com.definex.androidwork.data

import com.definex.androidwork.api.BaseApiResponse
import com.definex.androidwork.api.NetworkResult
import com.definex.androidwork.model.ProductApiResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): BaseApiResponse(){
    suspend fun getProducts(): Flow<NetworkResult<ProductApiResponse>> {
        return flow {
            emit(apiCall {
                remoteDataSource.getProducts()
            })
        }.flowOn(Dispatchers.IO)
    }
}
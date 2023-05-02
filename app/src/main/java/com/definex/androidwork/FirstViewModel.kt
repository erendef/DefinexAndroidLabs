package com.definex.androidwork

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.definex.androidwork.api.NetworkResult
import com.definex.androidwork.data.Repository
import com.definex.androidwork.model.Product
import com.definex.androidwork.model.ProductApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
): AndroidViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<ProductApiResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<ProductApiResponse>> = _response

    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>> = _productList

    fun fetchApiResponse() = viewModelScope.launch {
        repository.getProducts().collect{ responseValues ->
            _productList.value = responseValues.data?.productList
        }
    }
}
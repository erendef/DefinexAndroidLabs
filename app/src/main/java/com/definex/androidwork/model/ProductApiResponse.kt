package com.definex.androidwork.model

import com.google.gson.annotations.SerializedName


data class ProductApiResponse(
    @SerializedName("products")
    val productList: List<Product>
)

data class Product(
    @SerializedName("title")
    var title: String
)

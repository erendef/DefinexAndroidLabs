package com.definex.androidwork.model

import com.google.gson.annotations.SerializedName


data class ProductApiResponse(
    @SerializedName("products")
    val productList: List<Product>
)

data class Product(
    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("price")
    val price: Int,

    @SerializedName("discountPercentage")
    val discountPercentage: Float,

    @SerializedName("brand")
    val brand: String,

    @SerializedName("images")
    val images: List<String>
)

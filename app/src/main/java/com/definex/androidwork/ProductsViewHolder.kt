package com.definex.androidwork

import androidx.recyclerview.widget.RecyclerView
import com.definex.androidwork.databinding.ItemProductBinding
import com.definex.androidwork.model.Product

class ProductsViewHolder(
    private val productsItemBinding: ItemProductBinding
): RecyclerView.ViewHolder(productsItemBinding.root) {
    fun bind(product: Product) {
        productsItemBinding.product = product
    }
}

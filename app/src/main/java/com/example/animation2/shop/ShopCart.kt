package com.example.animation2.shop

class ShopCart {
    companion object {
        val productsCart: MutableList<Product> = mutableListOf()
    }

    fun getProducts(): MutableList<Product> {
        return productsCart
    }

    fun addProductInCart(product: Product) {
        val myProduct: Product = product
        myProduct.isShopCart = true
        myProduct.count = 1
        for (i in productsCart) {
            if (i.id == myProduct.id) {
                i.count++
                return
            }
        }
        productsCart.add(myProduct)
    }

    fun deleteProductInCart(index: Int) {
        if (productsCart[index].count > 1) productsCart[index].count--
        else productsCart.removeAt(index)
    }
}
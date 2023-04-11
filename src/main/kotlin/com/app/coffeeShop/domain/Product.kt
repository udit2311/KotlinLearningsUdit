package com.app.coffeeShop.domain

open class Product(val id: Int, val productName: String, val price: Double) {
    override fun toString(): String {
        return "Id=$id, Name='$productName', Price=$price\n"
    }
}
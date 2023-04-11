package com.app.coffeeShop.utils

import com.app.coffeeShop.domain.Coffee
import com.app.coffeeShop.domain.IceCream

class DBUtils {
    private val listOfCoffee: List<Coffee> =
        listOf(
            Coffee(1, "NESCAFE", 50.00),
            Coffee(2, "LATTE", 70.00),
            Coffee(3, "CAPPUCCINO", 80.00),
            Coffee(4, "MOCHA", 100.00)
        )

    fun printCoffee() {
        println(listOfCoffee)
    }

    fun getCoffeeById(id: Int): Coffee? {
        return listOfCoffee.find { id == it.id }
    }

    private val listOfIceCream: List<IceCream> =
        listOf(
            IceCream(1, "VANILLA", 60.00),
            IceCream(2, "CHOCOLATE", 70.00),
            IceCream(3, "MANGO", 80.00)
        )

    fun printIceCream() {
        println(listOfIceCream)
    }

    fun getIceCreamById(id: Int): IceCream? {
        return listOfIceCream.find { id == it.id }
    }
}
package com.app.coffeeShop.domain

class Order {
    private val mapOfOrders: MutableMap<Product, Int> = mutableMapOf()

    fun orderCoffee(coffee: Coffee, qtyCoffee: Int) {
        if (qtyCoffee > 0)
            mapOfOrders[coffee] = qtyCoffee
        else
            println("Something Went Wrong!!!")
    }

    fun orderIceCream(iceCream: IceCream, qtyIceCream: Int) {
        if (qtyIceCream > 0)
            mapOfOrders[iceCream] = qtyIceCream
        else
            println("Something Went Wrong!!!")
    }

    fun getOrderDetails() {
        mapOfOrders.forEach { (product, qty) ->
            println("ID=${product.id} | Name=${product.productName} | Rate=${product.price} | Quantity=$qty")
        }
    }

    fun printBill() {
        println("----------------------------------------")
        println("Order Details:")
        getOrderDetails()
        val total =
            mapOfOrders.map { (prod, quantity) -> prod.price * quantity }
                .sum()
        println("----------------------------------------")
        println("Total Amount = $total\nReward Points = ${(total / 150).toInt()}")
        println("Rs.150 order purchase = 1 Reward Point")
        println("----------------------------------------")
    }

}

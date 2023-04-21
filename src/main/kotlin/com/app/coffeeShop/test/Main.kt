package com.app.coffeeShop.test

import com.app.coffeeShop.domain.Order
import com.app.coffeeShop.utils.DBUtils
import java.util.*

fun main(args: Array<String>) {

    var flag: Boolean = true
    val sc = Scanner(System.`in`)

    val order: Order = Order()

    var choice: Int = 0
    val util: DBUtils = DBUtils()

    var chooseProduct: Int = 0
    var coffeeID: Int = 0
    var qtyCoffee: Int = 0
    var iceCreamID: Int = 0
    var qtyIceCream: Int = 0

    println("Welcome to our cafe:")
    WhileLoop@ while (flag) {
        println("1 : Order Something")
        println("2 : Update Order")
        println("3 : Print Order")
        println("4 : Print Bill")
        println("5 : Exit")
        print("Enter your choice please: ")
        choice = sc.nextInt()

        when (choice) {
            1 -> {
                if (qtyCoffee == 0 && qtyIceCream == 0) {
                    print("1: Coffee\n2: Ice Cream\nWhat would you like to have?: ")
                    chooseProduct = sc.nextInt()
                    if (chooseProduct == 1 || chooseProduct == 2) {
                        when (chooseProduct) {
                            1 -> {
                                println(util.printCoffee())
                                print("Which Coffee ID?: ")
                                coffeeID = sc.nextInt()
                                print("Quantity?: ")
                                qtyCoffee = sc.nextInt()
                                util.getCoffeeById(coffeeID)?.let { coffee ->
                                    order.orderCoffee(coffee, qtyCoffee)
                                } ?: continue@WhileLoop
                                println("Coffee Added")

                            }

                            2 -> {
                                println(util.printIceCream())
                                print("Which Ice Cream?: ")
                                iceCreamID = sc.nextInt()
                                print("Quantity?: ")
                                qtyIceCream = sc.nextInt()
                                util.getIceCreamById(iceCreamID)?.let { iceCream ->
                                    order.orderIceCream(iceCream, qtyIceCream)
                                } ?: continue@WhileLoop
                                println("Ice Cream Added")
                            }
                        }
                        order.getOrderDetails()
                    }
                } else {
                    println("Kindly choose 'Update Order' for modification")
                }
            }

            2 -> {
                if (qtyCoffee > 0 || qtyIceCream > 0) {
                    print("1: Coffee\n2: Ice Cream\nWhat would you like to modify?: ")
                    chooseProduct = sc.nextInt()
                    if (chooseProduct == 1 || chooseProduct == 2) {
                        when (chooseProduct) {
                            1 -> {
                                println(util.printCoffee())
                                print("Which Coffee ID?: ")
                                coffeeID = sc.nextInt()
                                if(qtyCoffee != 0) print("Additional Quantity?: ")
                                else print("Quantity?: ")
                                qtyCoffee += sc.nextInt()
                                util.getCoffeeById(coffeeID)?.let { coffee ->
                                    order.orderCoffee(coffee, qtyCoffee)
                                } ?: continue@WhileLoop
                            }

                            2 -> {
                                println(util.printIceCream())
                                print("Which Ice Cream?: ")
                                iceCreamID = sc.nextInt()
                                if(qtyIceCream != 0) print("Additional Quantity?: ")
                                else print("Quantity?: ")
                                qtyIceCream += sc.nextInt()
                                util.getIceCreamById(iceCreamID)?.let { iceCream ->
                                    order.orderIceCream(iceCream, qtyIceCream)
                                } ?: continue@WhileLoop
                            }
                        }
                        println("Order Modified")
                        order.getOrderDetails()
                    }
                } else {
                    println("Kindly choose 'Order Something' for initial order")
                }
            }

            3 -> {
                if (qtyCoffee > 0 || qtyIceCream > 0) {
                    order.getOrderDetails()
                } else {
                    println("Cart is empty currently")
                }
            }

            4 -> {
                if (qtyCoffee > 0 || qtyIceCream > 0) {
                    order.printBill()
                } else {
                    println("Kindly order something before printing bill")
                }
            }

            5 -> {
                println("Thank You!! Visit Again!!")
                flag = false
            }

            else -> {
                println("Invalid Input!! Please try again!!")
            }
        }
    }
}

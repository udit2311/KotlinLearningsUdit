package conceptPractice.scopeFunctions

import java.util.*
import kotlin.reflect.typeOf

fun main(args: Array<String>) {
    val name: String? = null
//  println(name!!)  // gives NullPointerException

    name?.let {
        println(it)      // won't execute as [name] is [null]
    }

    val sc = Scanner(System.`in`)
    print("Kindly type anything: ")
    val anotherName: Any? = sc.nextLine()
    anotherName?.let {
        println(it)     // prints value of [anotherName] as it's [not null]
    }
}
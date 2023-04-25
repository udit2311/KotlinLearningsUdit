package conceptPractice.scopeFunctions

// allows you to run code on an object without calling any of its methods

class Company{
    var a: String = "a"
    var b: Int = 7
}

fun main(args: Array<String>) {
    val companyObj: Company = Company()
    val a = 12
    val b = "b"

    with(companyObj){
        println(this.a)
        println(this.b)
    }

    println(a)
    println(b)

}
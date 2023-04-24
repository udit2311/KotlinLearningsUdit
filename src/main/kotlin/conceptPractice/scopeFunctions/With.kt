package conceptPractice.scopeFunctions

// allows you to run code on an object without calling any of its methods

class Company{
    var a: String = ""
    var b: Int = 0
}

fun main(args: Array<String>) {
    val companyObj: Company = Company()

    println(with(companyObj){
        this.a = "String is assigned to 'a'"
        this.b = 7
    })

    val print = with(companyObj){
        this.a = "String is assigned to 'a'"
        this.b = 7
    }

}
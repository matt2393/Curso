class Prueba() {
    lateinit var x: String
    init {


    }
    fun nom(){

        print(x.toDouble())
    }
}

fun main() {

   /* var a: Int? = null

    a=5
    var c = suma(a!!, 10)
    print(c)*/

    //var a = 0

    //var g: Prueba = Prueba()
    //g.nom()
    val c = multi(b = 5.0)
    print(c)
}
fun suma(x: Int, y: Int) = x + y
fun algo(): Double {
    //varias cosa
    return 0.0
}
fun suma2(x: Int, y: Int) {
    print(x+y)
}

fun multi(a: Int = 10, b: Double = 7.0) = a * b

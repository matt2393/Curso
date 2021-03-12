class Comida(var n: Int) {

    lateinit var nombre: String
    lateinit var precio: String

    companion object {
        val TAG = Comida::class.java.name
    }

    fun mostrarNombre() {
        println(nombre)
    }

    /**
     * solo sirve dentro de la clase
     */
    inner class Algo {
    }
}

object Cola {

    private var n = "Hola"
    private var a = 9
    private var apellido = ""
    fun mostrar(){
        println(n)
    }
    fun editar(nom: String){
        n = nom
    }
    fun editar(a: String, x: String){

    }
}

data class Usuario(var user: String = "",
                   var password: String="",
                   var tipo: Int = 0){
    constructor():this("","")
    constructor(tipoU: Int):this("","", tipoU)
    constructor(us: String):this(user = us){
    }
    init {

    }
}




fun main() {
    /*var sopa = Comida(5)
    sopa.mostrarNombre()
    Comida.TAG
    val hotdog = Comida(6)

    Cola.mostrar()
    Cola.editar("hhh")
    Cola.mostrar()*/

  //  var us = Usuario()
  //  println(us.toString())

    var us2 = Usuario(2)
    var us3 = Usuario("Matt Dev")

}
class Comida(var n: Int) {

    lateinit var nombre: String
    lateinit var precio: String

    companion object{
        val TAG = "dsada"
    }

    public fun mostrarNombre(){
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
    fun mostrar(){
        println(n)
    }
    fun editar(nom: String){
        n = nom
    }
}



fun main() {
    /*var c = Comida(5)
    c.mostrarNombre()
    Comida.TAG
    val c2 = Comida(6)*/

    Cola.mostrar()
    Cola.editar("hhh")
    Cola.mostrar()

}
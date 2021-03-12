/**
 * public -> Cualquiera puede acceder
 * private -> solo la clase puede acceder
 * protected -> solo la clase y sus herederos pueden
 *              acceder
 */

open class Persona {
    protected var nombre: String = ""
    private var nombre2: String = ""
    private var edad: Float = 2f
    open fun mostrar(){
        print(nombre)
    }
    open fun editar(){
    }
    fun guardar(){
    }
}
class Politico: Persona() {
    override fun mostrar(){
        super.mostrar()
        super.nombre = ""
        print("dsada")
    }
}

abstract class Postres {
    fun cocinar(){
    }
    abstract fun hornear()
}


abstract class Postres2 {
    var nom: String = ""
    fun cocinar(){
    }
    abstract fun hornear()
}
/**
 * Clases solo pueden heredar de una clase
 * Clases pueden heredar de multiples interfaces
 */
class Torta: Postres(), Ingredientes2 {
    override fun hornear() {

    }

    override fun addHarina2(h: String) {
        TODO("Not yet implemented")
    }

    override fun addHarina(h: String) {
        TODO("Not yet implemented")
    }


}

interface Ingredientes {

    fun addHarina(h: String)
}
interface Ingredientes2: Ingredientes {
    fun addHarina2(h: String)
}
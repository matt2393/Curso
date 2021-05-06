/**
 * Clase hereda de Herramientas
 * se añade despues del nombre dos puntos :
 * y el nombre de la clase del que se quiere heredar
 * con parentesis al final si es clase
 * y parametros si se requiere del constructor del padre
 */
class Martillo(var ext: String): Herramientas("") {
    var otro: String = ""
    init {
        otro = "$nombre$ext"
    }
    fun mostrar() {
        nombre

    }
    fun golpear(){
        getTam()
    }
}
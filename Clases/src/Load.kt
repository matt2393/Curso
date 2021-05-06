/**
 * la interface es como una clase abstracta
 * solo que la interface no tiene instancia
 * No se puede instanciar
 *
 * sus funciones puede o no implementarse
 * las funciones no implementadas
 * deben ser si o si implementadas por
 * las clases descendientes
 */

interface Load {
    fun mostrarCarga()
    fun noMostrar(){
        print("dsdsa")
    }
}
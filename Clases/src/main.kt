

fun mostrarHer(h: Herramientas){
    println(h.toString())
}
fun mostrarMAr(m: Martillo){
    println(m.toString())
}

fun mostrarLoad(l: Load) {
    l.mostrarCarga()
}

fun main() {
    val h = Herramientas("")
    h.getTam()
    /**
     * la clase padre no puede reemplazar
     * a la clase hija
     */
   // mostrarMAr(h)


    val m = Martillo("s")
    m.peso


    /**
     * interface no se puede instanciar
     */
    //val load = Load()


    /**
     * la clase hija si puede reemplazar
     * a la clase padre
     */
    mostrarHer(m)


    /**
     *
     */

    val av = Avion()
    val mo = Moto()

    /**
    supongamos que este main es nuestra activity
     y queremos llamar a la funcion de los fragments
     */
    var fr: Vehiculo = av

    fr = mo

    (fr as Load).mostrarCarga()


    println()
    println()
    println()
    av.setClick(object : clickListener{
        override fun onClick() {
            print("mostrar algo")
        }
    })
    av.mm()


}
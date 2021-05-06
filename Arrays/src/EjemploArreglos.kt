

var array2: ArrayList<Producto>? = null
fun main() {
    array2 = arrayListOf()
    /**
     * Formas de inicializar un arrayList
     * ambos son el mismo arrayList
     */
    /**
     * inicializar arraylist de forma normal
     * la variable array asume que tipo de datos es
     * cuando se iguala en la misma linea
     */
    val array = ArrayList<Producto>()
    array.add(Producto())
    /**
     * inicializar arraylist de forma adicional en kotlin
     * en el cual se puede añadir datos dentro de los parentesis
     * que inicializaran el array con esos datos y de ese tipo
     * la variable array asume que tipo de datos es
     * cuando se iguala en la misma linea
     */
    // array de tipo Any por que se añadio varios tipos de valores
    // al instanciar
    val array1 = arrayListOf(true, 3, "", Producto())
    array1.add(6)

    /**
     * forEach recorre todo el array
     * de principio a fin de uno en uno
     */
    array1.forEach {
        /**
         * "is" es para saber de que tipo de dato
         * es la variable
         * en este casi la variable it
         */
        if(it is Producto) {
            println(it.nombre)
        } else {
            println(it)
        }
    }
    println()
    println()
    println()

    array1.forEach {
        when(it) {
            is Producto -> {
                println(it.nombre)
            }
            is Boolean -> {
                println("esto es booleano")
            }
            is String -> println("String vacio")
            else -> {
                println("Es otra cosa")
            }
        }
    }
    println()
    println()
    println()
    /**
     * arrays siempre comienzan en la posicion o indice 0
     * y van hasta size - 1
     * ejemplo
     * si el array es de size 5
     * los indices o posiciones seran de 0 a 4
     */
    for(i in array1.size-1 downTo 0 ){
        val it = array1[i]
        when(it) {
            is Producto -> {
                println(it.nombre)
            }
            is Boolean -> {
                println("esto es booleano")
            }
            is String -> println("String vacio")
            else -> {
                println("Es otra cosa")
            }
        }
    }



    /**
     * comprobar o estar seguro de que la variable
     * no sea nulo, para usar !!
     */
    //algo(array2!!.size)

    /**
     * puede o no ser nulo
     */
    //print(array2?.size)

    println()
    println()
    println()
    /**
     * Array es distinto al arrayList
     * el ArrayList es de tamaño flexible o dinamico
     * el Array es de tamaño definido o estico
     */
    val ar = Array<Int>(5) { 3 }
    ar.forEach {
        println(it)
    }
    println()
    println()
    println()
    val ar1 = Array<Int>(5) {
        it+4
    }
    ar1.forEach {
        println(it)
    }
    /**
     * otra forma de inicializar un array estatico
     */
    val ar2: Array<Int> = arrayOf(3,5,1,9)

    /**
     * ordenamiento
     */
    val r = ar2.sortedArray()
    println()
    ar2.forEach {
        println(it)
    }
    println()
    r.forEach {
        println(it)
    }

    /**
     * Ordenar por un parametro del objeto
     */
    val productos = arrayListOf(
            Producto("Pepsi", 5.5),
            Producto("Choq", 1.0),
            Producto("Azucar", 10.8),
            Producto("Papel", 8.3)
    )
    productos.sortBy {
        it.precio
    }
    println()
    println(productos.toString())



}

fun algo(s: Int) {

}
/**
 * clase especializada en manejo de datos
 * es recomendable usarlo para modelos de datos o entidades
 *
 * las funciones dentro de estas, se recomiendan que
 * tengan que ver con el manejo de datos
 *
 *
 */

data class Producto(var nombre: String = "",
                    var precio: String = "") {
    fun mostrar() {

    }

    /**
     * "apply" obtiene la instancia inmediata del objeto
     * "also" devuelve la instancia del objeto
     */
    fun toMap() = HashMap<String, Any>().apply {
        put("nombre", nombre)
        this["precio"] = precio
    }
}
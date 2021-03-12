
fun main() {

    val m = HashMap<String, Int>()
    m["Apellido"] = 1
    m["Nombre"] = 7
    m["matt"] = 5

    m.keys.forEach {
        println(m[it])
    }
    val datos = ArrayList(m.values)
    datos.sort()
    datos.forEach { println(it) }
}
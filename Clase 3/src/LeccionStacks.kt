import kotlin.math.pow

/**
 * Clase generica
 */
class Pila<T> {
    private val p = arrayListOf<T>()
    fun push(dato: T){
        p.add(dato)
    }
    fun top() =
        if(p.size>0){
            p[p.size-1]
        } else{
            null
        }

    fun pop(){
        if(p.size>0){
            p.removeAt(p.size-1)
        }
    }
}

fun main() {
    /*val peliculas = Pila<String>()
    println("El tope")
    println(peliculas.top())
    peliculas.push("Avengers")
    peliculas.push("Forest Gump")
    peliculas.push("Spiderman")
    println("El tope")
    println(peliculas.top())
    peliculas.pop()
    println("El tope")
    println(peliculas.top())*/
    var exp = readLine()
    var expP = convertir(exp!!)
    println(expP)
    var resul = evaluador(expP)
    println(resul)
}

fun valor(signo: Char) =
    when(signo){
        '^'->3
        '/','*'->2
        '+','-'->1
        else -> 0
    }
fun convertir(expresion: String): String {
    val p = Pila<Char>()
    val exp = "($expresion)"
    var expPol = ""
    exp.forEach {  c ->
        when(c){
            '('->p.push(c)
            '^','/','*','+','-'->{
                while (valor(c)<=valor(p.top()!!)){
                    expPol += p.top()
                    p.pop()
                }
                p.push(c)
            }
            ')'-> {
                while (p.top()!='('){
                    expPol += p.top()
                    p.pop()
                }
                p.pop()
            }
            else -> {
                expPol += c
            }
        }
    }
    return expPol
}
fun evaluador(expPol: String): Double? {
    var res: Double? = null
    val p = Pila<Double>()
    expPol.forEach {

        when(it){
            '^','/','*','+','-'-> {
                val b = p.top()!!
                p.pop()
                val a = p.top()!!
                p.pop()
                val r = when(it){
                    '^'-> a.pow(b)
                    '/'-> a/b
                    '*'-> a*b
                    '+'-> a+b
                    else-> a-b
                }
                p.push(r)
            }
            else -> {
                p.push(it.toString().toDouble())
            }
        }
    }
    res = p.top()
    return res
}
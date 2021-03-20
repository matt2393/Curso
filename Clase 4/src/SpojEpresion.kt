import java.util.*

fun prioridad(x: Char) = when(x){
    '^'->3
    '*','/'->2
    '-','+'->1
    else -> 0
}

fun convertir(exp: String): String{
    val p = Stack<Char>()
    var expPol = ""

    exp.forEach {
        when(it){
            '(' -> p.push(it)
            ')'-> {
                while(p.peek()!='('){
                    expPol += p.pop()
                }
                p.pop()
            }
            '^','/','*','+','-' -> {
                while (prioridad(it) <= prioridad(p.peek())){
                    expPol += p.pop()
                }
                p.push(it)
            }
            else -> expPol += it
        }
    }
    return expPol
}
fun main() {
    val t = readLine()?.toShort()
    for (i in 1..t!!) {
        val exp = readLine()
        println(convertir(exp!!))
    }
}
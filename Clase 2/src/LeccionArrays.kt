import kotlin.random.Random

data class Prod(var nombre: String = "",
                var precio: Float = 0f,
                var cantidad: Int = 0)

fun main() {
    val p1 = Prod("Pepsi", 5.5f,10)
    val p2 = Prod("CocaCola", 7.5f, 5)
    val p3 = Prod("Galletas", 1.5f, 90)
    val p4 = Prod("Arroz", 25.5f, 15)
    val p5 = Prod("Cucharas", 2.5f, 300)

    val prods = arrayListOf(p1,p2,p3,p4,p5)
    prods.forEach {
        println(it.toString())
    }
    prods.sortBy { it.precio }

    println()
    println()
    prods.forEach {
        println(it.toString())
    }

    prods.sortByDescending { it.cantidad }

    println()
    println()
    prods.forEach {
        println(it.toString())
    }

    for(i in 0 until prods.size) {
        for(j in i until prods.size) {
            if(i!=j){
                if(prods[i].precio > prods[j].precio){
                    val pAux = prods[i]
                    prods[i] = prods[j]
                    prods[j] = pAux
                }
            }
        }
    }

    println()
    println()
    prods.forEach {
        println(it.toString())
    }


    for(it in prods){
        it.precio += (it.precio*0.1).toFloat()
    }
    println()
    println()
    prods.forEach {
        println(it.toString())
    }

}
fun arrays1(){
    val a = arrayListOf<Int>()


    var mat = ArrayList<ArrayList<Int>>()
    var aux = 1

    var ran = Random(71)
    for(i in 0..5){
        mat.add(arrayListOf())
        for(j in 0..4){
            mat[i].add(aux)
            aux++
        }
    }
    for(i in 0 until mat.size){
        for(j in mat[i].size-1 downTo 0){
            print("${mat[i][j]}\t")
        }
        println()
    }
    /* mat.forEach {
         it.forEach { ar ->
             print("$ar \t")
         }
         println()
     }*/

}
fun suma(a: Int, b: Int):Int{
    return 0
}
var suma2 = {a:Int, b: Int -> Int
    0
}

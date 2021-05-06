

class Avion : Vehiculo(), Load, Load2{
    private var cl: clickListener? = null
    override fun manejar() {

    }

    override fun mostrarCarga() {
        print("esto es un avion")
        //hace otra cosa
    }

    override fun noMostrar() {
        super.noMostrar()
    }
    override fun mm() {
        cl?.onClick()
    }

    fun setClick(c: clickListener) {
        cl = c
    }
}
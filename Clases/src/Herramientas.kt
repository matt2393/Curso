/**
 * clase normal
 * una clase tiene atributos y métodos
 */

/**
 * si se desea que esta clase tenga descendiantes
 * se debe anotar la palabra reservada "open"
 */
open class Herramientas(/**
                    * constructor principal
                    */nom: String) {
    protected var nombre: String = nom
    private var tamanio: String = ""
    public var peso: String = ""
    internal var fuerza: String = ""

    /**
     * constructor secundarios
     */
    /*constructor(nom: String, tamanio: String){
        nombre = nom + "algo"
    }
    constructor() {
    }*/

    /**
     * Palabras reservada
     * Private -> solo la clase puede acceder
     * Protected -> solo la clase puede acceder,
     *              y sus clases descendiantee
     * Public    -> Todos pueden accder
     * Internal  -> solo se accede dentro del modulo ()
     */
    fun getTam(): String {

        return tamanio
    }

    /**
     * en una clase normal si o si se deben implementar
     * todos sus métodos
     */
    //fun vender()

}
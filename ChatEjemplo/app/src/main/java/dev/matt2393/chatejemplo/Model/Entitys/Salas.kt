package dev.matt2393.chatejemplo.Model.Entitys

data class Salas(var id: String = "",
                 var uids: ArrayList<String> = arrayListOf(),
                 var ultimoMensaje: String = "",
                 var ultimaHora: Long = 0L,
                 var image: String = "",
                 var nombre: ArrayList<Us> = arrayListOf()){

    data class Us(var uid: String = "", var nombre: String = "")
}
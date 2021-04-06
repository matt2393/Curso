package dev.matt2393.chatejemplo.Model.Entitys

data class Chat(var id: String = "",
                var uidChat: String = "",
                var uidEmisor: String = "",
                var mensaje: String = "",
                var timestamp: Long = 0)

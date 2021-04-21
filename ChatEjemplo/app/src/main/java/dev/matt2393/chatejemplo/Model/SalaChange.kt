package dev.matt2393.chatejemplo.Model

import com.google.firebase.firestore.DocumentChange
import dev.matt2393.chatejemplo.Model.Entitys.Salas

data class SalaChange(var tipo: DocumentChange.Type, var sala: Salas)
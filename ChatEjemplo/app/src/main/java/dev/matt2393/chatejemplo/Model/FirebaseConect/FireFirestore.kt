package dev.matt2393.chatejemplo.Model.FirebaseConect

import com.google.firebase.firestore.FirebaseFirestore
import dev.matt2393.chatejemplo.Model.Entitys.Salas
import dev.matt2393.chatejemplo.Model.Entitys.Usuario
import kotlinx.coroutines.tasks.await

suspend fun getUsers(uid: String) = FirebaseFirestore.getInstance()
    .collection("Usuario")
    .whereNotEqualTo("uid", uid)
    .get()
    .await()

suspend fun saveUsser(us: Usuario) = FirebaseFirestore.getInstance()
    .collection("Usuario")
    .add(us)
    .await()

suspend fun saveSala(salas: Salas) = FirebaseFirestore.getInstance()
    .collection("Sala")
    .add(salas)
    .await()

fun getSalas(uid: String) = FirebaseFirestore.getInstance()
    .collection("Sala")
    .whereArrayContains("uids", uid)

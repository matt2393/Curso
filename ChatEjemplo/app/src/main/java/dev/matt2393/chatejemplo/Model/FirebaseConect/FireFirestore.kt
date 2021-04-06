package dev.matt2393.chatejemplo.Model.FirebaseConect

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

suspend fun getUsers(uid: String) = FirebaseFirestore.getInstance()
    .collection("Usuario")
    .whereNotEqualTo("uid", uid)
    .get()
    .await()
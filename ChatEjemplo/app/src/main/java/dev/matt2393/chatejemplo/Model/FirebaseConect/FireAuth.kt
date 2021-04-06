package dev.matt2393.chatejemplo.Model.FirebaseConect

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import kotlinx.coroutines.tasks.await

suspend fun authPhone(cred: PhoneAuthCredential) =
    FirebaseAuth.getInstance().signInWithCredential(cred).await()

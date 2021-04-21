package dev.matt2393.chatejemplo.sala

import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ListenerRegistration
import dev.matt2393.chatejemplo.Model.Entitys.Salas
import dev.matt2393.chatejemplo.Model.FirebaseConect.getSalas
import dev.matt2393.chatejemplo.Model.SalaChange
import dev.matt2393.chatejemplo.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class SalaRepo {
    var listener: ListenerRegistration? = null
    @ExperimentalCoroutinesApi
    suspend fun getSa(uid: String): Flow<Result<SalaChange>> = callbackFlow{
        withContext(Dispatchers.IO) {
            listener = getSalas(uid).addSnapshotListener { value, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }
                value?.documentChanges?.forEach {
                    
                    val salaC = SalaChange(it.type, it.document.toObject(Salas::class.java))
                    sendBlocking(Result.Success(salaC))
                }
            }
            awaitClose{listener?.remove()}
        }

    }

    fun removeListener() {
        listener?.remove()
    }
}
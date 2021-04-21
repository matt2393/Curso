package dev.matt2393.chatejemplo.login

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import dev.matt2393.chatejemplo.Model.Entitys.Salas
import dev.matt2393.chatejemplo.Model.Entitys.Usuario
import dev.matt2393.chatejemplo.Model.FirebaseConect.authPhone
import dev.matt2393.chatejemplo.Model.FirebaseConect.getUsers
import dev.matt2393.chatejemplo.Model.FirebaseConect.saveSala
import dev.matt2393.chatejemplo.Model.FirebaseConect.saveUsser
import dev.matt2393.chatejemplo.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LoginRepo {
    suspend fun login(cred: PhoneAuthCredential): Result<FirebaseUser> {
        return withContext(Dispatchers.IO) {
            try {
                val auth = authPhone(cred)
                Result.Success(auth.user)
            } catch (ex: Exception) {
                Result.Error(ex)
            }
        }
    }
    suspend fun getUs(uid: String): Result<List<Usuario>> {
        return withContext(Dispatchers.IO) {
            try {
                val us = getUsers(uid)
                val array = arrayListOf<Usuario>()
                us.documents.forEach {
                    val u = it.toObject(Usuario::class.java)
                    u?.uid = it.id
                    if(u!=null) {
                        array.add(u)
                    }
                }
                Result.Success(array)
            } catch (ex: Exception) {
                Result.Error(ex)
            }
        }
    }

    suspend fun saveUs(us: Usuario) =
        withContext(Dispatchers.IO) {
            try {
                val u = saveUsser(us)
                Result.Success(u)
            } catch (ex: Exception) {
                Result.Error(ex)
            }
        }

    suspend fun saveSalas(salas: ArrayList<Salas>) =
        withContext(Dispatchers.IO) {
            try {
                salas.forEach {
                    saveSala(it)
                }
                Result.Success(true)
            } catch(ex: Exception) {
                Result.Error(ex)
            }
        }
}
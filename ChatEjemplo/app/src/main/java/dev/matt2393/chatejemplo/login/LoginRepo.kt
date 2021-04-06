package dev.matt2393.chatejemplo.login

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import dev.matt2393.chatejemplo.Model.FirebaseConect.authPhone
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
}
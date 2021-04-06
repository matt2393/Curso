package dev.matt2393.chatejemplo.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import dev.matt2393.chatejemplo.Result
import kotlinx.coroutines.launch


class LoginViewModel(private val loginRepo: LoginRepo = LoginRepo()): ViewModel() {
    val user = MutableLiveData<FirebaseUser?>().apply { value = null }
    val error = MutableLiveData<Exception>().apply { value = Exception() }
    val isLoading = MutableLiveData<Boolean>().apply { value = false }

    fun login(cred: PhoneAuthCredential) {
        isLoading.value = true
        viewModelScope.launch {
            val res = loginRepo.login(cred)
            isLoading.value = false
            when(res) {
                is Result.Success -> user.value = res.data
                is Result.Error -> error.value = res.ex
            }
        }
    }
}
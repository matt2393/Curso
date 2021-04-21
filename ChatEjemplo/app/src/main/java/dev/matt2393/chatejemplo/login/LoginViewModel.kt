package dev.matt2393.chatejemplo.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import dev.matt2393.chatejemplo.Model.Entitys.Salas
import dev.matt2393.chatejemplo.Model.Entitys.Usuario
import dev.matt2393.chatejemplo.Result
import kotlinx.coroutines.launch


class LoginViewModel(private val loginRepo: LoginRepo = LoginRepo()): ViewModel() {
    val user = MutableLiveData<FirebaseUser?>().apply { value = null }
    val error = MutableLiveData<Exception>().apply { value = Exception() }
    val isLoading = MutableLiveData<Boolean>().apply { value = false }
    val usSave = MutableLiveData<Boolean>().apply { value = false }
    val users = MutableLiveData<List<Usuario>>().apply { value = arrayListOf() }
    val salaSave = MutableLiveData<Boolean>().apply { value = false }

    fun login(cred: PhoneAuthCredential) {
        isLoading.value = true
        viewModelScope.launch {
            val res = loginRepo.login(cred)
            when(res) {
                is Result.Success -> user.value = res.data
                is Result.Error -> error.value = res.ex
            }
        }
    }
    fun saveU(number: String) {
        val us = Usuario()
        us.telefono = number
        us.nombre = number
        viewModelScope.launch {
            val res = loginRepo.saveUs(us)
            when(res) {
                is Result.Success -> usSave.value = true
                is Result.Error -> error.value = res.ex

            }
        }
    }
    fun getUs(uid: String) {
        viewModelScope.launch {
            val res = loginRepo.getUs(uid)
            when(res) {
                is Result.Success -> users.value = res.data
                is Result.Error -> error.value = res.ex

            }
        }
    }
    fun saveSalas(salas: ArrayList<Salas>) {
        viewModelScope.launch {
            val res = loginRepo.saveSalas(salas)
            isLoading.value = false
            when(res) {
                is Result.Success -> salaSave.value = res.data
                is Result.Error -> error.value = res.ex
            }
        }
    }
}
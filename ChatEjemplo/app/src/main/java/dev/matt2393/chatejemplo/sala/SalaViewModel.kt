package dev.matt2393.chatejemplo.sala

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.matt2393.chatejemplo.Model.SalaChange
import dev.matt2393.chatejemplo.Result
import kotlinx.coroutines.launch

class SalaViewModel(private val salaRepo: SalaRepo = SalaRepo()): ViewModel() {
    val salas = MutableLiveData<List<SalaChange>>().apply { value = arrayListOf() }

    fun getSalasChat(uid: String) {
        viewModelScope.launch {
            val res = getSalasChat(uid)
            when(res) {
                is Result.Success<*> -> salas.value = res.data as List<SalaChange>?
            }
        }
    }

}
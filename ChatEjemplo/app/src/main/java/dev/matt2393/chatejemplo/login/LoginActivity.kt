package dev.matt2393.chatejemplo.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.ktx.Firebase
import dev.matt2393.chatejemplo.MainActivity
import dev.matt2393.chatejemplo.Model.Entitys.Salas
import dev.matt2393.chatejemplo.databinding.ActivityLoginBinding
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var callback: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private var codigoSMS = ""
    private var codigoEnviado = false

    private val viewmodel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(FirebaseAuth.getInstance().currentUser!=null) {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
            finish()
        }

        binding.buttonLogin.setOnClickListener {
            if(codigoEnviado) {
                val cod = binding.editCodigoLogin.text.toString()
                comprobar(cod)
            } else {
                val num = "+"+binding.editTelefonoLogin.text.toString()
                prepareLogin(num)
            }
        }


        callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                login(p0)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Log.e("ErrorPhone", p0.toString())
                Toast.makeText(this@LoginActivity, "Error ", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                codigoSMS = p0
                codigoEnviado = true
                binding.textinputCodigoLogin.visibility = View.VISIBLE
            }

        }
    }

    private fun prepareLogin(numero: String) {
        val op = PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
            .setPhoneNumber(numero)
            .setActivity(this)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setCallbacks(callback)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(op)
    }
    private fun comprobar(codInsertado: String) {
        val cred = PhoneAuthProvider.getCredential(codigoSMS, codInsertado)
        login(cred)
    }
    private fun login(credencial: PhoneAuthCredential){
        viewmodel.login(credencial)
    }

    override fun onStart() {
        super.onStart()
        initObservers()
    }

    override fun onStop() {
        super.onStop()
        viewmodel.user.removeObservers(this)
        viewmodel.error.removeObservers(this)
        viewmodel.isLoading.removeObservers(this)
        viewmodel.usSave.removeObservers(this)
        viewmodel.users.removeObservers(this)
        viewmodel.salaSave.removeObservers(this)
    }

    private fun initObservers() {
        viewmodel.user.observe(this, {
            if(it!=null) {
                viewmodel.saveU(it.phoneNumber!!)
            }
        })
        viewmodel.error.observe(this, {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })
        viewmodel.isLoading.observe(this, {
            if(it) {

            } else {

            }
        })

        viewmodel.usSave.observe(this, {
            if(it) {
                viewmodel.getUs(FirebaseAuth.getInstance().currentUser!!.uid)
            }
        })

        viewmodel.users.observe(this, {
            if(it.isNotEmpty()) {
                val uid = FirebaseAuth.getInstance().currentUser!!.uid
                val nombre = FirebaseAuth.getInstance().currentUser!!.phoneNumber!!
                val array = arrayListOf<Salas>()
                it.forEach { us->
                    val sala = Salas()
                    sala.nombre = arrayListOf(Salas.Us(uid,nombre), Salas.Us(us.uid, us.nombre))
                    sala.uids = arrayListOf(uid, us.uid)
                    array.add(sala)
                }
                viewmodel.saveSalas(array)
            }
        })
        viewmodel.salaSave.observe(this, {
            if(it) {
                startActivity(
                    Intent(this, MainActivity::class.java)
                )
                finish()
            }
        })
    }
}
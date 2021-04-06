package dev.matt2393.chatejemplo.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import dev.matt2393.chatejemplo.MainActivity
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

        binding.buttonLogin.setOnClickListener {
            if(codigoEnviado) {
                val cod = binding.editCodigoLogin.text.toString()
                comprobar(cod)
            } else {
                val num = binding.editTelefonoLogin.text.toString()
                prepareLogin(num)
            }
        }


        callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                login(p0)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
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
    }

    private fun initObservers() {
        viewmodel.user.observe(this, {
            if(it!=null) {
                startActivity(
                    Intent(this, MainActivity::class.java)
                )
                finish()
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
    }
}
package dev.matt2393.clase1android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.matt2393.clase1android.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_login)

        binding.buttonLogin.setOnClickListener {
            Toast.makeText(this, "Holaaa", Toast.LENGTH_SHORT).show()
        }
        /*val idProd = intent.getStringExtra("IDPROD")
        if (idProd!=null){

        }else {

        }*/

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }
}
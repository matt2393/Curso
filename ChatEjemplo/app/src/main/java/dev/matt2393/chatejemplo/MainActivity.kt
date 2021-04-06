package dev.matt2393.chatejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.matt2393.chatejemplo.chat.ChatFragment
import dev.matt2393.chatejemplo.lista.ListaFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerMain, ChatFragment())
            .commit()
    }
}
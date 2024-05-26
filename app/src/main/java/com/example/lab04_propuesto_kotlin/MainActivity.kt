package com.example.lab04_propuesto_kotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    private lateinit var account:AccountEntity;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnAddAccount = findViewById<Button>(R.id.btnAddAccount)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        Log.d("MainActivity", "Main")

        btnAddAccount.setOnClickListener{
            val registroFragment = RegistroFragment.newInstance(response)
            Log.d("btnAddAccount", "ClickListener")
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack(null)
                replace(R.id.contenedorFragment, registroFragment)
            }
        }
        btnLogin.setOnClickListener {
            Log.d("AccountEntity", "Nombre: " + account.getFirstname())
        }
    }
    val response:(AccountEntity)->Unit={cuenta ->
        account = cuenta
    }
}
package com.example.projetofirebase

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Firebase Auth
        val auth = Firebase.auth
        Log.i(TAG, "Usuário criado com sucesso! ")



        auth.createUserWithEmailAndPassword(
            "admin@admin.com.br",
            "@cst2025"
        ).addOnCompleteListener{ task ->
            if(task.isSuccessful){
                Log.i(TAG, "Usuário criado com sucesso! ")

            }else{
                Log.i(TAG, "Falha na criação! -> ${task.exception}")

            }
        }
    }

}
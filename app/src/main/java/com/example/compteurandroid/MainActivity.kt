package com.example.compteurandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewCompteur: TextView
    private var compteur = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewCompteur = findViewById(R.id.textViewCompteur)

        val buttonIncrementer = findViewById<Button>(R.id.buttonIncrementer)
        val buttonDecrementer = findViewById<Button>(R.id.buttonDecrementer)
        val buttonReinitialiser = findViewById<Button>(R.id.buttonReinitialiser)

        if (savedInstanceState != null) {
            compteur = savedInstanceState.getInt(KEY_COMPTEUR, 0)
        }
        updateCompteurUI()

        buttonIncrementer.setOnClickListener {
            compteur++
            updateCompteurUI()
        }

        buttonDecrementer.setOnClickListener {
            compteur--
            updateCompteurUI()
        }

        buttonReinitialiser.setOnClickListener {
            compteur = 0
            updateCompteurUI()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COMPTEUR, compteur)
    }

    private fun updateCompteurUI() {
        textViewCompteur.text = compteur.toString()
    }

    companion object {
        private const val KEY_COMPTEUR = "key_compteur"
    }
}
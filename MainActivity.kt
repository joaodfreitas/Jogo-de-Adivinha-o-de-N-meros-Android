package com.example.adivinhacao

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextGuess = findViewById<EditText>(R.id.editTextGuess)
        val buttonCheckGuess = findViewById<Button>(R.id.buttonCheckGuess)
        val textViewHint = findViewById<TextView>(R.id.textViewHint)

        // Gerar um número aleatório ao iniciar o app
        randomNumber = Random.nextInt(1, 101)

        buttonCheckGuess.setOnClickListener {
            val userGuess = editTextGuess.text.toString().toIntOrNull()

            if (userGuess != null) {
                when {
                    userGuess < randomNumber -> textViewHint.text = "Seu palpite é muito baixo."
                    userGuess > randomNumber -> textViewHint.text = "Seu palpite é muito alto."
                    else -> textViewHint.text = "Parabéns! Você acertou."
                }
            } else {
                textViewHint.text = "Por favor, insira um número válido."
            }
        }
    }
}
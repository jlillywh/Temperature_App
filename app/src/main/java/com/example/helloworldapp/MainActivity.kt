package com.example.helloworldapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


const val EXTRA_MESSAGE = "com.example.helloworldapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    var letter: Char = 'A'
    var score1: Int = 0
    var score2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player1_score = findViewById<TextView>(R.id.player1_score)
        val player1_submit = findViewById<Button>(R.id.player1_submit)

        val player2_score = findViewById<TextView>(R.id.player2_score)
        val player2_submit = findViewById<Button>(R.id.player2_submit)

        val letter_display = findViewById<TextView>(R.id.letter_display)

        player1_submit.setOnClickListener{
            letter++
            score1++
            player1_score.setText("SCORE:  $score1")
            letter_display.setText(letter.toString())
        }

        player2_submit.setOnClickListener{
            letter++
            score2++
            player2_score.setText("SCORE:  $score2")
            letter_display.setText(letter.toString())
        }
    }

    /**
     * Called when the user taps the Send button
     */
    fun sendMessage(view: View){
        val editText = findViewById<EditText>(R.id.editText)
        val player1_score = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, player1_score)
        }
        startActivity(intent)
    }
}
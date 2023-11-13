package com.example.staringservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.etInput)
        startButton = findViewById(R.id.btnStart)

        startButton.setOnClickListener {
            startCountdownService()
        }
    }

    private fun startCountdownService() {
        val countdownValue = editText.text.toString().toIntOrNull()
        if (countdownValue != null && countdownValue > 0) {
            val intent = Intent(this, CountDownService::class.java)
            intent.putExtra(CountDownService.EXTRA_COUNTDOWN_VALUE, countdownValue)
            startService(intent)
        } else {
            // Handle invalid input
            editText.error = "Enter a valid countdown value"
        }
    }
}
package com.example.staringservices

import android.app.IntentService
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountDownService: IntentService("CountdownService") {

    override fun onHandleIntent(intent: Intent?) {
        val countdownValue = intent?.getIntExtra(EXTRA_COUNTDOWN_VALUE, 0) ?: 0

        if (countdownValue > 0) {
            runCountdown(countdownValue)
        }
    }

    private fun runCountdown(countdownValue: Int) {
        GlobalScope.launch {
            for (i in countdownValue downTo 1) {
                Log.d(TAG, "Countdown: $i")
                delay(1000)
            }
            Log.d(TAG, "Countdown complete")
        }
    }
    companion object {
        const val EXTRA_COUNTDOWN_VALUE = "countdown_value"
        private const val TAG = "CountdownService"
    }
}
package com.example.responsi3055

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var txtBalance: TextView
    private val REQUEST_CODE_TOP_UP = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtBalance = findViewById(R.id.textBallance)
//        updateBalanceText()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dial: TextView = findViewById(R.id.textPhone)
        dial.setOnClickListener {
            val dialIntent: Intent = Uri.parse("tel: 0895380187668").let {
                number -> Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(dialIntent)
        }
        val topUp: TextView = findViewById(R.id.menuTopUp)
        topUp.setOnClickListener {
            val topUpIntent: Intent = Intent(this, TopUpActivity::class.java)
            startActivity(topUpIntent)
        }
        val outcome: TextView = findViewById(R.id.menuOutcome)
        outcome.setOnClickListener{
            val outcomeIntent: Intent = Intent(this, OutcomeActivity::class.java)
            startActivity(outcomeIntent)
        }
        val history: TextView = findViewById(R.id.menuHistory)
        history.setOnClickListener{
            val historyIntent: Intent = Intent(this, HistoryActivity::class.java)
            startActivity(historyIntent)
        }
    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == REQUEST_CODE_TOP_UP && resultCode == RESULT_OK) {
//            // Jika top up berhasil, update saldo
//            updateBalanceText()
//        }
//    }

//    private fun updateBalanceText() {
//        val sharedPreferences = getSharedPreferences("eWallet", Context.MODE_PRIVATE)
//        val currentBalance = sharedPreferences.getFloat("balance", 0f)
//        txtBalance.text = getString(R.string.balance, currentBalance) // Gunakan string resource untuk format
//    }
}
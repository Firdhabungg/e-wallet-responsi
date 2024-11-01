package com.example.responsi3055

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TopUpActivity : AppCompatActivity() {
    private lateinit var editTextTopUp: EditText
    private lateinit var tombolSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_top_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editTextTopUp = findViewById(R.id.editTextTopUp)
        tombolSimpan = findViewById(R.id.buttonSave)

        val txtKembali: TextView = findViewById(R.id.textBack)
        txtKembali.setOnClickListener {
            finish() // Kembali ke MainActivity
        }
        tombolSimpan.setOnClickListener {
            topUpSaldo()
        }
    }
    private fun topUpSaldo() {
        val jumlahString = editTextTopUp.text.toString()

        if (jumlahString.isEmpty()) {
            Toast.makeText(this, "Masukkan jumlah top up", Toast.LENGTH_SHORT).show()
            return
        }

        val jumlah = jumlahString.toDouble()

        // Update saldo di SharedPreferences
        val sharedPreferences = getSharedPreferences("eWallet", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val saldoSekarang = sharedPreferences.getFloat("balance", 0f)
        editor.putFloat("balance", (saldoSekarang + jumlah).toFloat())
        editor.apply()

        Toast.makeText(this, "Top up berhasil: $jumlah", Toast.LENGTH_SHORT).show()

        // Reset input field
        editTextTopUp.setText("")
        setResult(RESULT_OK) // Kirim hasil kembali ke MainActivity
        finish() // Kembali ke MainActivity
    }
}
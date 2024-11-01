package com.example.responsi3055

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerViewHistory: RecyclerView = findViewById(R.id.recycleViewHistory)
        recyclerViewHistory.layoutManager = GridLayoutManager(this, 1)
        val txtKembali: TextView = findViewById(R.id.textBack3)
        txtKembali.setOnClickListener {
            finish() // Kembali ke MainActivity
        }
        val menu = ArrayList<MenuTopUp>()
        menu.add(MenuTopUp(R.drawable.baseline_monetization_on_24, 1000000, "Gaji Bulanan"))
        menu.add(MenuTopUp(R.drawable.baseline_monetization_on_24, 10000000, "Give Away WS"))
        menu.add(MenuTopUp(R.drawable.baseline_monetization_on_24, 20000000, "Tabungan"))

        val adapterHistory = AdapterHistory(menu)
        recyclerViewHistory.adapter = adapterHistory
    }
}
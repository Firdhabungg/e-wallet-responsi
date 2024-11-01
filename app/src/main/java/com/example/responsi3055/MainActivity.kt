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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        val recyclerView: RecyclerView = findViewById(R.id.recyclerTransaction)
        recyclerView.layoutManager = GridLayoutManager(this, 1)



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
        val menu = ArrayList<MenuTopUp>()
        menu.add(MenuTopUp(R.drawable.baseline_monetization_on_24, 1000000, "Gaji Bulanan"))
        menu.add(MenuTopUp(R.drawable.baseline_monetization_on_24, 10000000, "Give Away WS"))
        menu.add(MenuTopUp(R.drawable.baseline_monetization_on_24, 20000000, "Tabungan"))

        val adapterTopUp = AdapterTopUp(menu)
        recyclerView.adapter = adapterTopUp

    }
}
package com.example.responsi3055

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTopUp (private val listTopUp: ArrayList<MenuTopUp>) :
    RecyclerView.Adapter<AdapterTopUp.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val icon : ImageView
        val harga : TextView
        val caption : TextView

        init {
            icon = v.findViewById(R.id.imageViewMonotize)
            harga = v.findViewById(R.id.textViewHarga)
            caption = v.findViewById(R.id.textViewGaji)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_view_menu, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelTopUp = listTopUp[position]
        holder.icon.setImageResource(modelTopUp.icon)
        holder.harga.text = modelTopUp.harga.toString()
        holder.caption.text = modelTopUp.caption
    }
    override fun getItemCount(): Int {
        return listTopUp.size
    }
}
package com.example.mobileproject.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.R

class SearchItemAdapter(private val itemList: List<SearchItem>) :
    RecyclerView.Adapter<SearchItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textMain: TextView = view.findViewById(R.id.textMain)
        val textName: TextView = view.findViewById(R.id.textName)
        val textLocation: TextView = view.findViewById(R.id.textLocation)
        val textContact: TextView = view.findViewById(R.id.textContact)
        val thumbnail: ImageView = view.findViewById(R.id.thumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.textMain.text = item.title
        holder.textName.text = "ผู้แจ้ง : ${item.name}"
        holder.textLocation.text = "สถานที่หาย : ${item.location}"
        holder.textContact.text = "ติดต่อที่ : ${item.contact}"
        holder.thumbnail.setImageResource(item.imageRes)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
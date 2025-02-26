package com.example.mobileproject.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.R

class MyAdapter(private val itemList: List<List<User>>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        
            val userList = itemList[position] // List<User> ของตำแหน่งนี้
            var x = userList.size - 1 // ตั้งค่าเริ่มที่ index สูงสุด
            var textResult = "" // ตัวแปรสะสมข้อความ

            // ใช้ while loop เพื่อวนลูปจากท้ายไปหน้า
            while (x >= 0) {
                textResult += userList[x].fname + "\n" // เพิ่ม fname ของแต่ละคน
                x -= 1 // ลดค่า x ไปเรื่อย ๆ
            }

            holder.textView.text = textResult.trim() //

    }

    override fun getItemCount() = itemList.size
}
package com.example.mobileproject.ui.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.R

class MyAdapter(private val itemList: List<List<User>>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewItem)
        val image_main:ImageView = view.findViewById(R.id.imageView6)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val userList = itemList[position] // List<User> ของตำแหน่งนี้
            val main_img = itemList[position]
            var x = userList.size - 1 // ตั้งค่าเริ่มที่ index สูงสุด
            var textResult = "" // ตัวแปรสะสมข้อความ
            var img_all = ""

            // ใช้ while loop เพื่อวนลูปจากท้ายไปหน้า
            while (x >= 0) {
                textResult += userList[x].fname + "\n" // เพิ่ม fname ของแต่ละคน
                val img_string = Base64.decode(userList[x].img1, Base64.DEFAULT)
                fun decodeBase64ToBitmap(): Bitmap? {
                    return try {
                        // val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
                        val decodedBytes = Base64.decode(img_string, Base64.DEFAULT)
                        BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        null
                    }
                }
                val userImageBitmap = decodeBase64ToBitmap()
                holder.image_main.setImageBitmap(userImageBitmap)


                x -= 1 // ลดค่า x ไปเรื่อย ๆ
            }

            holder.textView.text = textResult.trim() //



    }

    override fun getItemCount() = itemList.size
}
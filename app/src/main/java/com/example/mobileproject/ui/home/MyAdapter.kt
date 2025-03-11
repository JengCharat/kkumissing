package com.example.mobileproject.ui.home

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.R
var item_id:String = ""
class MyAdapter(private val itemList: List<List<User>>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val textView: TextView = view.findViewById(R.id.textViewItem)
        val imageContainer: LinearLayout = view.findViewById(R.id.imageContainer) // LinearLayout สำหรับรูปภาพ
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }
    /*
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val userList = itemList[position] // List<User> ของตำแหน่งนี้
            var textResult = "" // ตัวแปรสะสมข้อความ
            holder.imageContainer.removeAllViews() // ล้างรูปเก่าก่อนเพิ่มใหม่

            // วนลูปเพื่อเพิ่มชื่อและรูปภาพทุกคนใน userList
            for (user in userList) {
                textResult += user.fname + "\n" // เพิ่มชื่อของแต่ละคน

                // ดีโค้ด Base64 เป็น Bitmap
                println("xxxccxxxxxxxxxx")
                fun decodeBase64Android(base64String: String): String {
                    val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
                    return String(decodedBytes, Charsets.UTF_8)
                }
                println(decodeBase64Android(user.img1))
                val x = decodeBase64Android(user.img1)
                fun decodeBase64ToBitmap(): Bitmap? {
                    return try {
                        // val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
                        val decodedBytes = Base64.decode(x, Base64.DEFAULT)
                        BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        null
                    }
                }
                //val userImageBitmap = decodeBase64ToBitmap()


                val userImageBitmap = decodeBase64ToBitmap()

                userImageBitmap?.let {
                    // สร้าง ImageView ใหม่สำหรับแต่ละรูปภาพ
                    val imageView = ImageView(holder.imageContainer.context).apply {
                        layoutParams = ViewGroup.LayoutParams(200, 200) // ขนาดของรูปภาพ
                        scaleType = ImageView.ScaleType.CENTER_CROP
                        setImageBitmap(it)
                    }

                    holder.imageContainer.addView(imageView) // เพิ่ม ImageView ลงใน LinearLayout

                }
                holder.textView.text = textResult.trim()
            }

         // แสดงชื่อ
        }*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userList = itemList[position] // List<User> ของตำแหน่งนี้
        holder.imageContainer.removeAllViews() // ล้างรูปเก่าก่อนเพิ่มใหม่

        // วนลูปเพื่อเพิ่มชื่อและรูปภาพทุกคนใน userList
        for (user in userList) {

            // ดีโค้ด Base64 เป็น Bitmap
            val imgString = decodeBase64Android(user.img1)
            val userImageBitmap = decodeBase64ToBitmap(imgString)

            // สร้าง ImageView สำหรับแสดงรูปภาพ
            userImageBitmap?.let {
                val imageView = ImageView(holder.imageContainer.context).apply {
                    layoutParams = ViewGroup.LayoutParams(200, 200) // ขนาดของรูปภาพ
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImageBitmap(it)
                }

                // สร้าง TextView สำหรับแสดงชื่อ
                val textView = TextView(holder.imageContainer.context).apply {
                    text = user.fname // แสดงชื่อของ User
                    textSize = 18f
                    setTextColor(Color.BLACK)
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                }

                // สร้าง LinearLayout สำหรับการจัดเรียงรูปภาพและข้อความ
                val innerLayout = LinearLayout(holder.imageContainer.context).apply {
                    orientation = LinearLayout.HORIZONTAL // แนวนอน
                    addView(imageView) // เพิ่ม ImageView
                    addView(textView)  // เพิ่ม TextView
                }



                // เพิ่ม LinearLayout ลงใน imageContainer
                holder.imageContainer.addView(innerLayout)
                textView.setOnClickListener {
                    // เปลี่ยนขนาดของ ImageView เมื่อคลิกที่ TextView
                    /*val layoutParams = imageView.layoutParams
                    layoutParams.width = 400  // กำหนดขนาดใหม่
                    layoutParams.height = 400
                    imageView.layoutParams = layoutParams

                    // เปลี่ยนสีของข้อความ (textView) เพื่อบ่งชี้ว่าได้คลิกแล้ว
                    textView.setTextColor(Color.RED)
    */
                    // พิมพ์ชื่อผู้ใช้ใน Log
                    val intent = Intent(holder.itemView.context, More_detail::class.java)
                    holder.itemView.context.startActivity(intent)
                    item_id = user.id

                    println(textView.text)
                }

            }
        }
    }

    fun decodeBase64Android(base64String: String): String {
        val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
        return String(decodedBytes, Charsets.UTF_8)
    }

    fun decodeBase64ToBitmap(base64String: String): Bitmap? {
        return try {
            val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    override fun getItemCount() = itemList.size

}


/*class MyAdapter(private val itemList: List<List<User>>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

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
//            var x = userList.size - 1 // ตั้งค่าเริ่มที่ index สูงสุด
            var textResult = "" // ตัวแปรสะสมข้อความ
            var img_all = ""
            fun decodeBase64Android(base64String: String): String {
              val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
              return String(decodedBytes, Charsets.UTF_8)
            }
            // ใช้ while loop เพื่อวนลูปจากท้ายไปหน้า
            while (x >= 0) {

                textResult += userList[x].fname + "\n" // เพิ่ม fname ของแต่ละคน

                var img_string =  decodeBase64Android(userList[x].img1)


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
                img_all += userImageBitmap
                println("set tet")
                println(textResult)
                holder.image_main.setImageBitmap(img_all)
                println("set image")
                println(img_string)
                holder.textView.text = textResult.trim() //


                x -= 1 // ลดค่า x ไปเรื่อย ๆ
            }
        println("xxxxxx")




    }
    override fun getItemCount() = itemList.size
}*/
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
import androidx.core.content.res.ResourcesCompat
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
    val userList = itemList[position]
    holder.imageContainer.removeAllViews()

    // วนลูปเพื่อเพิ่มชื่อและรูปภาพทุกคนใน userList
    for (user in userList) {
        val imgString = decodeBase64Android(user.img1)
        val userImageBitmap = decodeBase64ToBitmap(imgString)

        userImageBitmap?.let {
            val imageView = ImageView(holder.imageContainer.context).apply {
                layoutParams = ViewGroup.LayoutParams(200, 200)
                scaleType = ImageView.ScaleType.CENTER_CROP
                setImageBitmap(it)
            }

            val textView = TextView(holder.imageContainer.context).apply {
                text =// user.fname
                """
                ${user.item_name}
                ผู้แจ้ง : ${user.fname}
                สถานที่หาย : ${user.lost_place}
                ติดต่อ : ${user.tel}
                """.trimIndent()
                textSize = 16f
                setTextColor(Color.WHITE)
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                // ตั้งค่าฟอนต์เป็น Prompt
                typeface = ResourcesCompat.getFont(context, R.font.prompt)
            }

            // สร้าง LayoutParams สำหรับ innerLayout
            val innerLayout = LinearLayout(holder.imageContainer.context).apply {
                orientation = LinearLayout.HORIZONTAL
                addView(imageView)
                addView(textView)

                // ตั้งค่า layoutParams ของ innerLayout
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    // ใช้ dp แทน px สำหรับความละเอียดที่แตกต่างกัน
                    val scale = holder.itemView.context.resources.displayMetrics.density
                    bottomMargin = (20 * scale).toInt() // ตั้งระยะห่าง 20dp
                    setMargins(10, 10, 10, 10)
                    setPadding(30, 30, 30,30)
                }
                this.layoutParams = layoutParams

                // เปลี่ยนสีพื้นหลังเป็นสีน้ำเงิน

                setBackgroundColor(Color.rgb(50,43,43))
            }

            // เพิ่ม innerLayout ลงใน imageContainer
            holder.imageContainer.addView(innerLayout)

            textView.setOnClickListener {
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

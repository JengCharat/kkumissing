package com.example.mobileproject.ui.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobileproject.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedInputStream
import java.io.IOException
import java.net.Socket
import java.net.URLEncoder


val top_left_latitude = 16.479029
val top_left_longitude = 102.806544
val top_right_latitude = 16.477245
val top_right_longitude = 102.832047
val buttom_left_latitude = 16.443679
val buttom_left_longitude = 102.804883
val buttom_right_latitude = 16.442214
val buttom_right_longitude = 102.827464
val max_hight_px = 1000
val max_width_px = 600
class More_detail : AppCompatActivity() {
    var back_img:ImageView?= null
    var fname:TextView?= null
    var lname:TextView?=null
    var item_type:TextView? = null
    var lost_place:TextView? = null
    var contact:TextView?= null
    var main_img:ImageView? = null
    var img2:ImageView?= null
    var img3:ImageView?= null
    var img4:ImageView?= null
    var gps_pin:ImageView?= null
    var item_name2:TextView?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        println(item_id)
        setContentView(R.layout.activity_more_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        get_data("select * from items where id = $item_id")
        back_img!!.setOnClickListener {
                finish() //กดปุ่มย้อนกลับแบบในมือถือ
        }
    }

    private fun init(){
        back_img = findViewById(R.id.back_button)
        fname = findViewById(R.id.fname)
        lname = findViewById(R.id.lname)
        item_type = findViewById(R.id.item_type)
        lost_place = findViewById(R.id.lost_place)
        contact = findViewById(R.id.contact)
        main_img = findViewById(R.id.main_img)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        img4 = findViewById(R.id.img4)
        gps_pin = findViewById(R.id.gps_pin)
        item_name2 = findViewById(R.id.item_name)
    }
    fun get_data(sqlCommand:String) {

        Thread {
            try {
                // ตั้งค่าข้อมูลที่ต้องการส่ง
                val host = "10.48.104.101"
                val path = "/myapi/test5.php"

                //val sqlCommand = "INSERT INTO name (name, image) VALUES ('admin3', '12')"
                //val sqlCommand = "select * from name where name = 'fan'"
                val postData = "sql_command=" + URLEncoder.encode(sqlCommand, "UTF-8") // URL Encode แค่ค่า ไม่รวม key

                // สร้าง HTTP Request แบบ Manual
                val request = StringBuilder()
                request.append("POST $path HTTP/1.1\r\n")
                request.append("Host: $host\r\n")
                request.append("Content-Type: application/x-www-form-urlencoded\r\n")
                request.append("Content-Length: ${postData.toByteArray().size}\r\n")
                request.append("Connection: close\r\n\r\n")
                request.append(postData)

                // แสดง HTTP Request ที่จะถูกส่งไป
                println("Request:\n$request")

                // สร้าง Socket ไปยังเซิร์ฟเวอร์
                val socket = Socket(host, 80)
                socket.soTimeout = 60000000
                // ส่งข้อมูลไปยังเซิร์ฟเวอร์
                val outputStream = socket.getOutputStream()
                outputStream.write(request.toString().toByteArray())
                outputStream.flush()
// ใช้ BufferedInputStream เพื่อรองรับข้อมูลขนาดใหญ่
                val inputStream = BufferedInputStream(socket.getInputStream())
                val byteArray = ByteArray(32)
                val responseBuilder = StringBuilder()

                var bytesRead: Int
                while (inputStream.read(byteArray).also { bytesRead = it } != -1) {
                    responseBuilder.append(String(byteArray, 0, bytesRead))
                }
                /*
                                // อ่าน Response จากเซิร์ฟเวอร์
                                val inputStream = socket.getInputStream()
                                val response = inputStream.bufferedReader().use { it.readText() }
                                println("Server Response:\n$response")*/
                // ปิดการเชื่อมต่อ
                socket.close()
                // อัปเดต UI บน Main Thread
                runOnUiThread {
                    //val responseBody = responseBuilder.toString().substringAfter("\r\n\r\n")
                    val responseBody = responseBuilder.toString()
                        .substringAfter("\r\n\r\n") // ตัด Header HTTP ออกก่อน
                        .substringAfter("[")        // เริ่มนับที่ `[`
                        .substringBeforeLast("]")   // จบที่ `]`
                        .let { "[$it]" }            // ใส่ `[` และ `]` กลับไป

                    val listType = object : TypeToken<List<User>>() {}.type
                    val users: List<User> = Gson().fromJson(responseBody, listType)

                    ///////////////////////////
                    val itemList = listOf(users)
                    ///////////////////////////


                    //nameTest.text = responseBody
                    // println(responseBody)
                    //var name_test:TextView? = null
                    //name_test = findViewById(R.id.name_test)

                    //name_test!!.text = users[0].name
                    println("get IMGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG123")
                    val x = Base64.decode(users[0].img1, Base64.DEFAULT)
                    //println(users[0].image)
                    // fun decodeBase64ToBitmap(base64String: String): Bitmap? {
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
                    val y = Base64.decode(users[0].img2, Base64.DEFAULT)
                    //println(users[0].image)
                    // fun decodeBase64ToBitmap(base64String: String): Bitmap? {
                    fun decodeBase64ToBitmap_img2(): Bitmap? {
                        return try {
                            // val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
                            val decodedBytes = Base64.decode(y, Base64.DEFAULT)
                            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            null
                        }
                    }
                    val z = Base64.decode(users[0].img3, Base64.DEFAULT)
                    //println(users[0].image)
                    // fun decodeBase64ToBitmap(base64String: String): Bitmap? {
                    fun decodeBase64ToBitmap_img3(): Bitmap? {
                        return try {
                            // val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
                            val decodedBytes = Base64.decode(z, Base64.DEFAULT)
                            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            null
                        }
                    }
                    val w = Base64.decode(users[0].img4, Base64.DEFAULT)
                    //println(users[0].image)
                    // fun decodeBase64ToBitmap(base64String: String): Bitmap? {
                    fun decodeBase64ToBitmap_img4(): Bitmap? {
                        return try {
                            // val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
                            val decodedBytes = Base64.decode(w, Base64.DEFAULT)
                            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            null
                        }
                    }

                    //val imageView: ImageView = binding.imageItem1
                    /*val fname:TextView = binding.firstName
                    val lname:TextView = binding.lastName
                    val item_name:TextView = binding.itemName
                    val more_datail:TextView = binding.moreDetail
                    val lost_place:TextView = binding.lostPlace
                    val contact:TextView = binding.contact
                    val latitude:TextView = binding.latitude
                    val longitude:TextView = binding.longitude



                    fname.text = users[0].fname
                    lname.text = users[0].lname
                    item_name.text = users[0].item_name
                    more_datail.text = users[0].more_datail
                    lost_place.text = users[0].lost_place
                    contact.text = users[0].contact
                    latitude.text = users[0].latitude
                    longitude.text = users[0].longitude*/
                    val userImageBitmap = decodeBase64ToBitmap()
                    val img2_decode = decodeBase64ToBitmap_img2()
                    val img3_decode = decodeBase64ToBitmap_img3()
                    val img4_decode = decodeBase64ToBitmap_img4()
                    main_img!!.setImageBitmap(userImageBitmap)
                    img2!!.setImageBitmap(img2_decode)
                    img3!!.setImageBitmap(img3_decode)
                    img4!!.setImageBitmap(img4_decode)
                    /*println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    println(userImageBitmap)
                    //imageView.setImageBitmap(userImageBitmap)
                    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    println("list test")
                    println("fffffffffnmaaaaaaaae")*/
                    fname!!.setText("first name:" + users[0].fname)
                    lname!!.setText("last name:" + users[0].lname)
                    item_type!!.setText("item type:" + users[0].type)
                    lost_place!!.setText("lost place"+users[0].lost_place)
                   contact!!.setText("contact" + users[0].contact)
                    item_name2!!.setText("itemName" + users[0].item_name)
                    gps_pin?.let { view ->
                        val params = view.layoutParams as ViewGroup.MarginLayoutParams



                        val longitude = if (users[0].longitude.isNullOrBlank() || users[0].longitude == "null") 1000.0 else users[0].longitude.toDouble()
                        val latitude = if (users[0].latitude.isNullOrBlank() || users[0].latitude == "null") 1000.0 else users[0].latitude.toDouble()

                        //val position_x = ((users[0].longitude.toDouble() - top_left_longitude)/(top_left_longitude - buttom_left_longitude)) * max_width_px
                        val position_x = ((longitude - top_left_longitude) / (top_right_longitude - top_left_longitude)) * max_width_px

                        val roundedPositionX = Math.abs(Math.ceil(position_x).toInt())
                        //val position_y = ((top_left_latitude - users[0].latitude.toDouble())/ top_left_latitude - buttom_left_latitude) * max_hight_px
                        val position_y = ((top_left_latitude - latitude) / (top_left_latitude - buttom_left_latitude)) * max_hight_px

                        val roundedPositionY = Math.abs(Math.ceil(position_y).toInt())
                        println("xxxxxxxxxxxxxxx")
                        println(roundedPositionX)
                        println("yyyyyyyyyyyyyyy")
                        println(roundedPositionY)

                        params.topMargin = roundedPositionY-100// กำหนด marginRight = 10pxparam
                        params.marginStart = roundedPositionX
                        view.layoutParams = params
                    }
                    gps_pin




                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }.start()

    }

}

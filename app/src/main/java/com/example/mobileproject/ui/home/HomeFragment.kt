package com.example.mobileproject.ui.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobileproject.databinding.FragmentHomeBinding
import java.io.BufferedInputStream
import java.io.IOException
import java.net.Socket
import java.net.URLEncoder
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class User(
    /*
    "id" => $row["id"],
"fname" => $row["fname"],
"lname" => $row["lname"],
"item_name" => $row["item_name"],
"more_detail" => $row["more_detail"],
"lost_place" => $row["lost_place"],
"contact" => $row["contact"],
"latitude" => $row["latitude"],
"longgitude" => $row["longgitude"],
"img1" =>  $img1,
"img2" =>  $img2,
"img3" =>  $img3,*/

    val id: String,            // ตัวแปร id จะเป็น Int สำหรับค่า AUTO_INCREMENT
    val fname: String,       // ตัวแปร name เป็น String สำหรับข้อความ
    val lname: String,
    val item_name: String,
    val more_datail: String,
    val lost_place:String,
    val contact:String,
    val latitude:String,
    val longitude:String,
    val img1:String,
)
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //test
    //
    //
    //
    //
    //
    //
    //
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.getButton.setOnClickListener {
            println("test click")
            get_data("select * from items where id = 11")
        }

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun get_data(sqlCommand:String) {

        Thread {
            try {
                // ตั้งค่าข้อมูลที่ต้องการส่ง
                val host = "192.168.11.252"
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
                activity?.runOnUiThread {
                    //val responseBody = responseBuilder.toString().substringAfter("\r\n\r\n")
                    val responseBody = responseBuilder.toString()
                        .substringAfter("\r\n\r\n") // ตัด Header HTTP ออกก่อน
                        .substringAfter("[")        // เริ่มนับที่ `[`
                        .substringBeforeLast("]")   // จบที่ `]`
                        .let { "[$it]" }            // ใส่ `[` และ `]` กลับไป

                    val listType = object : TypeToken<List<User>>() {}.type
                    val users: List<User> = Gson().fromJson(responseBody, listType)
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

                    val imageView: ImageView = binding.imageItem1
                    val fname:TextView = binding.firstName
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
                    longitude.text = users[0].longitude
                    val userImageBitmap = decodeBase64ToBitmap()
                    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    println(userImageBitmap)
                    imageView.setImageBitmap(userImageBitmap)





                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }.start()

    }
}
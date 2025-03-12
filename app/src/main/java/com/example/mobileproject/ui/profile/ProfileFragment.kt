package com.example.mobileproject.ui.profile

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentProfileBinding
import com.example.mobileproject.ui.home.MyAdapter
import com.example.mobileproject.ui.home.User
import com.example.mobileproject.ui.home.db_server_ip
import com.example.mobileproject.ui.home.selectedItem
import com.google.firebase.auth.FirebaseAuth
import com.example.mobileproject.ui.profile.ResultActivity
import com.example.mobileproject.ui.profile.LoginActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedInputStream
import java.io.IOException
import java.net.Socket
import java.net.URLEncoder

////////////////////////
import com.example.mobileproject.ui.dashboard.img1
import com.example.mobileproject.ui.dashboard.img2
import com.example.mobileproject.ui.dashboard.img3
import com.example.mobileproject.ui.dashboard.img4
import com.example.mobileproject.ui.notifications.contact
import com.example.mobileproject.ui.notifications.fname_2
import com.example.mobileproject.ui.notifications.item_name
import com.example.mobileproject.ui.notifications.item_type
import com.example.mobileproject.ui.notifications.latitude2
import com.example.mobileproject.ui.notifications.lname_2
import com.example.mobileproject.ui.notifications.longitude2
import com.example.mobileproject.ui.notifications.lost_place
import com.example.mobileproject.ui.notifications.more_detail
import com.example.mobileproject.ui.notifications.telNumber
import com.example.mobileproject.ui.home.HomeFragment
import com.example.mobileproject.ui.home.Users
import java.io.ByteArrayOutputStream
import java.io.InputStream
////////////////////////
var email2:String = ""

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private var mAuth: FirebaseAuth? = null
    private val TAG: String = "ProfileFragment"
    private var mainSignin: Button? = null
    var profile_image:String = ""
    val get_profile_Image = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                val img1_show: ImageView? = binding.profileImg
                img1_show!!.setImageURI(it) // แสดงภาพที่เลือก
                //val base64Image = encodeImageToBase64(it)
                //ImageData.base64Image = encodeImageToBase64(it)
                //println("Base64: $base64Image") // สามารถส่งค่า Base64 ไปยัง Server ได้
                profile_image = encodeImageToBase64(it).toString()
            }
        }
    }
                override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // เป็นการดึงข้อมูลการ login จาก Firebase Authentication
        mAuth = FirebaseAuth.getInstance()

        // กรณีที่มีการ login ค้างไว้ จะสามารถเข้าหน้า Result ได้เลย
        if (mAuth!!.currentUser != null) {
            email2 = mAuth!!.currentUser?.email.toString()
            binding.mainLoginButton?.setImageResource(R.drawable.log_out_btn) // เปลี่ยนรูปแทนข้อความ
            binding.gmail.setText("gmail: ${mAuth!!.currentUser?.email}")
            get("select * from items where email = '${mAuth!!.currentUser?.email}'")
        }
        else {
            binding.updateProfile.visibility = View.GONE
            binding.mainLoginButton?.setImageResource(R.drawable.log_in_btn) // เปลี่ยนรูปแทนข้อความ
        }
            binding.profileImg.setOnClickListener {
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                get_profile_Image.launch(intent)

            }
            binding.updateProfile.setOnClickListener {
                set_img()
        }
        binding.profileReportButton.setOnClickListener {
            get("SELECT * FROM items WHERE email = '${mAuth!!.currentUser?.email}'  AND report_or_missing = 2 ORDER BY id DESC;")
        }
        binding.profileFoundingButton.setOnClickListener {
            get("SELECT * FROM items WHERE email = '${mAuth!!.currentUser?.email}'  AND report_or_missing = 1 ORDER BY id DESC;")
        }

        binding.mainLoginButton?.setOnClickListener {
            if (mAuth!!.currentUser != null) {
                mAuth!!.signOut()
                Toast.makeText(requireContext(), "Signed out!", Toast.LENGTH_LONG).show()
                binding.mainLoginButton?.setImageResource(R.drawable.log_in_btn) // เปลี่ยนเป็นปุ่ม Login
            } else {
                binding.mainLoginButton?.setImageResource(R.drawable.log_out_btn) // เปลี่ยนเป็นปุ่ม Logout
                startActivity(Intent(requireActivity(), LoginActivity::class.java))
            }
        }

        binding.contactUsBtn.setOnClickListener {
            findNavController().navigate(R.id.contactUsFragment)
        }
        binding.aboutUsBtn.setOnClickListener {
            findNavController().navigate(R.id.aboutUsFragment)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun get(sqlCommand:String) {

        Thread {
            try {
                get_profile_image("select * from users where users.email = '${mAuth!!.currentUser?.email}'")

                // ตั้งค่าข้อมูลที่ต้องการส่ง
                val host = db_server_ip
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
                    if (users.isNullOrEmpty()) {
                        Toast.makeText(context, "not found", Toast.LENGTH_SHORT).show()
                        return@runOnUiThread
                    }

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

                    val userImageBitmap = decodeBase64ToBitmap()
                    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    println(userImageBitmap)



                    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    println("list test")
                    val recyclerView = view?.findViewById<RecyclerView>(R.id.user_item)
                    recyclerView?.layoutManager = LinearLayoutManager(requireContext())


                    recyclerView?.adapter = MyAdapter(itemList)
                    fun decodeBase64ToBitmap_profile_image(): Bitmap? {
                        return try {
                            // val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
                            val decodedBytes = Base64.decode(profile_image, Base64.DEFAULT)
                            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            null
                        }
                    }

                    val profile_image_decode = decodeBase64ToBitmap_profile_image()
                    binding.profileImg.setImageBitmap(profile_image_decode)


                    }
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }.start()

    }
    fun get_profile_image(sqlCommand:String) {

        Thread {
            try {
                // ตั้งค่าข้อมูลที่ต้องการส่ง
                val host = db_server_ip
                val path = "/myapi/test6.php"

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

                    val listType = object : TypeToken<List<Users>>() {}.type
                    val users: List<Users> = Gson().fromJson(responseBody, listType)
                    if (users.isNullOrEmpty()) {
                        Toast.makeText(context, "not found", Toast.LENGTH_SHORT).show()
                        return@runOnUiThread
                    }

                    ///////////////////////////
                    val itemList = listOf(users)
                    ///////////////////////////


                    //nameTest.text = responseBody
                    // println(responseBody)
                    //var name_test:TextView? = null
                    //name_test = findViewById(R.id.name_test)

                    //name_test!!.text = users[0].name
                    println("get IMGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG123")
                    val x = Base64.decode(users[0].profile, Base64.DEFAULT)
                    println(x)
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



                    val profile_image_decode = decodeBase64ToBitmap()
                    binding.profileImg.setImageBitmap(profile_image_decode)




                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }.start()

    }
    fun set_img() {
        //println("encode imageeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
        //println(ImageData.base64Image)
        Thread {
            try {
                val postData = "sql_command=" + URLEncoder.encode("UPDATE users SET profile = '$profile_image' WHERE email = '${mAuth!!.currentUser?.email}'", "UTF-8"
                ).trim()
                val host = db_server_ip
                val path = "/myapi/test5.php"
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
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }.start()

    }
    private fun encodeImageToBase64(imageUri: Uri): String? {
        return try {
            val inputStream: InputStream? = requireContext().contentResolver.openInputStream(imageUri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val outputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            val byteArray: ByteArray = outputStream.toByteArray()
            Base64.encodeToString(byteArray, Base64.DEFAULT)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

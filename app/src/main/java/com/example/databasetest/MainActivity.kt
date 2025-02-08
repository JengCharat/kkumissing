package com.example.databasetest

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.databasetest.R

data class User(
    val id: String,
    val name: String
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTextView: TextView = findViewById(R.id.name_test)  // เชื่อมกับ TextView
        val url = "http://192.168.11.252/myapi/getUsers.php"

        val request = object : StringRequest(Method.GET, url,
            Response.Listener { response ->
                Log.d("API", "Response: $response")

                // แปลง JSON Response เป็น List ของ User
                val gson = Gson()
                val listType = object : TypeToken<List<User>>() {}.type
                val users: List<User> = gson.fromJson(response, listType)

                // สร้างข้อความที่จะเอาไปแสดงใน TextView
                val userNames = users.joinToString(", ") { it.name }
                val userID = users.joinToString(", ") { it.id }
                nameTextView.text = userNames  // แสดงชื่อทั้งหมดใน TextView
            },
            Response.ErrorListener { error ->
                Log.e("API", "Error: ${error.message}")
                nameTextView.text = "Error: ${error.message}"  // แสดงข้อความผิดพลาด
            }) {}

        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(request)
    }
}

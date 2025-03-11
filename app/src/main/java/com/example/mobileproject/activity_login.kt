package com.example.mobileproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobileproject.ui.dashboard.ReportMissing1Fragment
import com.example.mobileproject.ui.home.HomeFragment
import com.example.mobileproject.ui.home.HomeViewModel

class Login : AppCompatActivity() {

    private var ButNextTo2: Button? = null
    private var inputuser: EditText? = null
    private var inputpass: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init() // ผูก UI กับตัวแปร

        // ตั้งค่า Event ให้กับปุ่ม Login
        ButNextTo2!!.setOnClickListener {
            val username = inputuser!!.text.toString().trim()
            val password = inputpass!!.text.toString().trim()

            if (!validateUsername(username)) {
                inputuser!!.error = "Username ต้องมี 6-12 ตัวอักษร และใช้ได้ทั้ง a-z, 0-9, _ หรือ ภาษาไทย"
            } else if (!validatePassword(password)) {
                inputpass!!.error = "Password ต้องมีตัวอักษรและตัวเลขอย่างน้อย 1 ตัว"
            } else {
                Toast.makeText(this, "Hello $username", Toast.LENGTH_LONG).show()

                // ✅ เปลี่ยนหน้าไป MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun init() {
        ButNextTo2 = findViewById(R.id.ButNextTo2)
        inputuser = findViewById(R.id.inputuser)
        inputpass = findViewById(R.id.inputpass)
    }

    // ✅ ตรวจสอบ Username: 6-12 ตัวอักษร, ใช้ได้ทั้ง a-z, 0-9, _ และ ภาษาไทย
    private fun validateUsername(username: String): Boolean {
        val regex = "^[a-zA-Z0-9_ก-ฮะ-า]{6,12}$".toRegex() // รองรับภาษาไทยด้วย
        return username.matches(regex)
    }

    // ✅ ตรวจสอบ Password: ต้องมีตัวอักษรและตัวเลขอย่างน้อย 1 ตัว
    private fun validatePassword(password: String): Boolean {
        val regex = "^(?=.*[a-zA-Z])(?=.*\\d).{6,}$".toRegex() // ไม่ต้องขึ้นต้นด้วยตัวอักษร แค่ต้องมีทั้งตัวอักษรและตัวเลข
        return password.matches(regex)
    }
}
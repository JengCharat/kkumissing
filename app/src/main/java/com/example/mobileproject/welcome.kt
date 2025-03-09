package com.example.mobileproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class welcome : AppCompatActivity() {

    private lateinit var randomText: TextView
    private lateinit var startButton: Button
    private val messages = listOf(
        "ของมีค่าของคุณอาจมีคนแจ้งหายแล้ว!",
        "คุณเจอของมีค่าแล้วนำมาแจ้ง ขอบคุณมากๆ",
        "ของหายหาง่ายเพียงกดค้นหา"
    )
    private var currentMessageIndex = 0
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        randomText = findViewById(R.id.randomText)
        startButton = findViewById(R.id.Butstart)

        // แสดงข้อความทีละข้อความ
        val messageRunnable = object : Runnable {
            override fun run() {
                randomText.text = messages[currentMessageIndex]
                currentMessageIndex = (currentMessageIndex + 1) % messages.size // หมุนข้อความ
                handler.postDelayed(this, 3000) // แสดงข้อความใหม่ทุก 3 วินาที
            }
        }

        // เริ่มต้นแสดงข้อความ
        handler.post(messageRunnable)

        // เมื่อกดปุ่มเริ่มต้น ไปยังหน้า Loading
        startButton.setOnClickListener {
            handler.removeCallbacks(messageRunnable) // หยุดการแสดงข้อความ
            val intent = Intent(this, Loading::class.java)
            startActivity(intent) // ไปหน้า Loading
            finish() // ปิดหน้า welcome
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

package com.example.mobileproject.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileproject.R

class activity_about_us : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        // ดึงปุ่มและ TextView มาใช้งาน
        val buttonWho = findViewById<Button>(R.id.buttonStep1)
        val textWho = findViewById<TextView>(R.id.textappear1)

        val buttonWhy = findViewById<Button>(R.id.buttonStep2)
        val textWhy = findViewById<TextView>(R.id.textappear2)

        val buttonWhen = findViewById<Button>(R.id.buttonStep3)
        val textWhen = findViewById<TextView>(R.id.textappear3)

        // ซ่อน TextView ทั้งหมดก่อน
        textWho.visibility = View.GONE
        textWhy.visibility = View.GONE
        textWhen.visibility = View.GONE

        // กดปุ่มเพื่อให้ข้อความแสดง/ซ่อน
        buttonWho.setOnClickListener { toggleVisibility(textWho) }
        buttonWhy.setOnClickListener { toggleVisibility(textWhy) }
        buttonWhen.setOnClickListener { toggleVisibility(textWhen) }
    }

    // ฟังก์ชันสลับสถานะการแสดงผลของ TextView
    private fun toggleVisibility(view: View) {
        view.visibility = if (view.visibility == View.VISIBLE) View.GONE else View.VISIBLE
    }
}

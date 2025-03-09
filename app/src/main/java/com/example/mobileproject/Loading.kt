package com.example.mobileproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.mobileproject.ui.dashboard.DashboardViewModel

class Loading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val loadingAnimation1 = findViewById<LottieAnimationView>(R.id.loadingAnimation1)
        val loadingAnimation2 = findViewById<LottieAnimationView>(R.id.loadingAnimation2)

        loadingAnimation1.playAnimation()
        loadingAnimation2.playAnimation()

        // 🔹 โหลดเสร็จแล้วไปหน้า Login
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }, 3000)  // โหลด 3 วินาที
    }
}

package com.example.mobileproject.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobileproject.R
import com.google.firebase.auth.FirebaseAuth

class ResultActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null
    private val TAG: String = "Result Activity"
    var userEmail: TextView? = null
    var uidUser: TextView? = null
    var singout: Button? = null
    var backRe: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
//ดึงค่ําจําก Firebase มําใส่ใน mAuth
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth!!.currentUser
//น ําค่ํามําใส่ลงใน TextView ที่สร้ํางขึ้น
        userEmail?.text = "Email : " + user!!.email
        uidUser?.text = "UID : " + user!!.uid
        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val users = firebaseAuth.currentUser
            if (users == null) {
                startActivity(Intent(this@ResultActivity,
                    LoginActivity::class.java))
                finish()
            }
        }


// กํารท ํางํานของปุ่ ม Sign out
        singout?.setOnClickListener {
            mAuth!!.signOut()
            Toast.makeText(this, "Signed out!", Toast.LENGTH_LONG).show()
            Log.d(TAG, "Signed out!")
            startActivity(Intent(this@ResultActivity, LoginActivity::class.java))
            finish()
        }
//กรณีกดปุ่ ม Back
        backRe?.setOnClickListener { onBackPressed() }
    }
    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener { mAuthListener }
    }
    override fun onStop() {
        super.onStop()
        if (mAuthListener != null) {
            mAuth!!.removeAuthStateListener { mAuthListener }
        }
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true)
        }
        return super.onKeyDown(keyCode, event)
    }
    private fun init() {
        userEmail = findViewById(R.id.result_emailData)
        uidUser = findViewById(R.id.result_uidData)
        singout = findViewById(R.id.result_signOutBtn)
        backRe = findViewById(R.id.result_backBtn)
    }
}
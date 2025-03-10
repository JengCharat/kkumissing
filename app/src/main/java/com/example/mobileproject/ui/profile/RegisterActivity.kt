package com.example.mobileproject.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobileproject.R
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    private val TAG: String = "Register Activity"
    var regisEmail: EditText? = null
    var regisPass: EditText? = null
    var regisConPass: EditText? = null
    var createAcc : Button? = null
    var rSignin : TextView? = null
    var backR : ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        mAuth = FirebaseAuth.getInstance()
        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this@RegisterActivity,
                ResultActivity::class.java))
            finish()
        }
        createAcc?.setOnClickListener {
            val email = regisEmail?.text.toString().trim { it <= ' ' }
            val password = regisPass?.text.toString().trim { it <= ' ' }
//ท ํากํารตรวจสอบก่อนว่ํามีข้อมูลหรือไม่
            if (email.isEmpty()) {
                Toast.makeText(this,"Please enter your email address.",
                    Toast.LENGTH_LONG).show()
                Log.d(TAG, "Email was empty!")
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(this,"Please enter your password.",Toast.LENGTH_LONG).show()
                        Log.d(TAG, "Password was empty!")
                return@setOnClickListener
            }
//กรณีที่มีข้อมูล จะท ํากํารตรวจสอบเงื่อนไขอื่น ๆ ก่อนท ํากําร create user
            mAuth!!.createUserWithEmailAndPassword(email,
                password).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    if (password.length < 6) { // ตรวจสอบควํามยําวของ password
                        Toast.makeText(this,"Password too short! Please enter minimum 6 characters.",Toast.LENGTH_LONG).show()
                                Log.d(TAG, "Enter password less than 6 characters.")
                    } else {
                        Toast.makeText(this,"Authentication Failed: " + task.exception!!.message,Toast.LENGTH_LONG).show()
                        Log.d(TAG, "Authentication Failed: " +
                                task.exception!!.message)
                    }
                } else {
                    Toast.makeText(this,"Create account successfully!", Toast.LENGTH_LONG).show()
                            Log.d(TAG, "Create account successfully!")
                    startActivity(Intent(this@RegisterActivity,
                        ResultActivity::class.java))
                    finish()
                }
            }
        }
//กรณีกดปุ่ ม Back
        backR?.setOnClickListener { onBackPressed() }
        rSignin?.setOnClickListener { startActivity(
            Intent(this@RegisterActivity,
            LoginActivity::class.java)
        ) }
    }
    private fun init(){
        regisEmail = findViewById(R.id.inputuser)
        regisPass = findViewById(R.id.inputpass)
        regisConPass = findViewById(R.id.inputpass2)
        createAcc = findViewById(R.id.ButNextTo3)
        rSignin = findViewById(R.id.ButNextTo2)
        backR = findViewById(R.id.register_backBtn)
    }
}
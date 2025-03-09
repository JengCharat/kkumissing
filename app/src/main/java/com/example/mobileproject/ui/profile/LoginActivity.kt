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

class LoginActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    private val TAG: String = "Login Activity"
    var loginBtn : Button? = null
    var userEmail: EditText? = null
    var userPass : EditText? = null
    var createUser : TextView? = null
    var backLogin : ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        mAuth = FirebaseAuth.getInstance()
        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this@LoginActivity, ResultActivity::class.java))
            finish()
        }
        loginBtn?.setOnClickListener {
            val email = userEmail?.text.toString().trim { it <= ' ' }
            val password = userPass?.text.toString().trim { it <= ' ' }
// ท ํากํารตรวจสอบก่อนว่ํามีข้อมูลหรือไม่ ก่อนที่จะไปตรวจสอบค่ํา
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
//ท ํากํารตรวจสอบค่ําที่กรอกกับค่ําจําก Firebase Authentication
            mAuth!!.signInWithEmailAndPassword(email,
                password).addOnCompleteListener { task ->
//กรณีที่ไม่ผ่ํานกํารตรวจสอบ
                if (!task.isSuccessful) {
//ตรวจสอบควํามยําวของ password ว่ําน้อยกว่ํา 6 ไหม
                    if (password.length < 6) {
                        userPass?.error = "Please check your password. Password must have minimum 6 characters."
                        Log.d(TAG, "Enter password less than 6 characters.")
                    } else {
                        Toast.makeText(this,"Authentication Failed: " + task.exception!!.message,Toast.LENGTH_LONG).show()
                        Log.d(TAG, "Authentication Failed: " +
                                task.exception!!.message)
                    }
                } else { //กรณีที่อีเมลและรหัสถูกต้อง
                    Toast.makeText(this,"Sign in successfully!",Toast.LENGTH_LONG).show()
                            Log.d(TAG, "Sign in successfully!")
                    startActivity(Intent(this@LoginActivity,
                        ResultActivity::class.java))
                    finish()
                }
            }
        }
//กรณีกดปุ่ ม create account
        createUser?.setOnClickListener { startActivity(
            Intent(this@LoginActivity,
            RegisterActivity::class.java)
        ) }
//กรณีกดปุ่ ม Back
        backLogin?.setOnClickListener { onBackPressed() }
    }
    private fun init(){
        userEmail = findViewById(R.id.inputuser)
        userPass = findViewById(R.id.inputpass)
        loginBtn = findViewById(R.id.ButNextTo2)
        createUser = findViewById(R.id.ButNextTo3)
        backLogin = findViewById(R.id.login_backBtn)
    }
}
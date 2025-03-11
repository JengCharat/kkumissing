package com.example.mobileproject.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportMissing1Binding
import com.example.mobileproject.ui.profile.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.mobileproject.ui.profile.ProfileFragment


var fname:String = ""
var lname:String = ""
class ReportMissing1Fragment : Fragment() {
    var mAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null

// binding.inputFname.text = ("Email : " + user!!.email)
    private var _binding: FragmentReportMissing1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //
    private val binding get() = _binding!!

//test
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)


        _binding = FragmentReportMissing1Binding.inflate(inflater, container, false)
        val root: View = binding.root
    mAuth = FirebaseAuth.getInstance()
    val user2 = mAuth!!.currentUser
    //น ําค่ํามําใส่ลงใน TextView ที่สร้ํางขึ้น
    if(user2?.email == null || user2?.email == ""){
        binding.inputFname.setText("")
    }
    else{
        println("have yser")
        binding.inputFname.setText(user2?.email)
    }


    //    val textView: TextView = binding.textDashboard
    //    dashboardViewModel.text.observe(viewLifecycleOwner) {
    //        textView.text = it
    //    }


    /*mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
        val users = firebaseAuth.currentUser
        if (users == null) {
            binding.inputFname.setText("")
        }
    }*/
        binding.ButNextTo2.setOnClickListener {
            fname = binding.inputFname.text.toString()
            lname = binding.inputLname.text.toString()
            println(fname)
            println(lname)
            findNavController().navigate(R.id.action_dashboardFragment_to_reportMissing2Fragment)
        
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
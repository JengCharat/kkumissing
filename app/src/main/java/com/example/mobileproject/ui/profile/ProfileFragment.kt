package com.example.mobileproject.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobileproject.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.example.mobileproject.ui.profile.ResultActivity
import com.example.mobileproject.ui.profile.LoginActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private var mAuth: FirebaseAuth? = null
    private val TAG: String = "ProfileFragment"
    private var mainSignin: Button? = null

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
            binding.mainLoginButton?.setText("logout")
        }
        else{
            binding.mainLoginButton?.setText("login")
        }




        binding.mainLoginButton ?.setOnClickListener {
            if (mAuth!!.currentUser != null) {
                mAuth!!.signOut()
                Toast.makeText(requireContext(), "Signed out!", Toast.LENGTH_LONG).show()
                binding.mainLoginButton?.setText("logout")
            }
            else{
                binding.mainLoginButton?.setText("login")
                startActivity(Intent(requireActivity(), LoginActivity::class.java))

            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

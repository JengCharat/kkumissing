
package com.example.mobileproject.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentProfileBinding
import com.example.mobileproject.ui.home.SearchItem
import com.example.mobileproject.ui.home.SearchItemAdapter

class ProfileFragment :  Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.missingBtn.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileMissing)
        }
        binding.reportAsLostBtn.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileAsLost)
        }
        //การตั้งค่า
        binding.editProfileBtn.setOnClickListener {
            findNavController().navigate(R.id.action_to_editProfile)
        }
        binding.contactUsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_to_contactUs)
        }
        binding.aboutUsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_to_aboutUs)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

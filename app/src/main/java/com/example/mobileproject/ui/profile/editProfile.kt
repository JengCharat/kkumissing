package com.example.mobileproject.ui.profile

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentEditProfileBinding
import com.google.android.material.imageview.ShapeableImageView


class editProfile : Fragment() {
    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!

    private var isDefaultImage = true  // สถานะรูปภาพปัจจุบัน

    // เปิด Gallery เพื่อเลือกภาพ
    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            binding.imageView3.setImageURI(it) // ตั้งค่ารูปที่เลือก
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.undoBtn.setOnClickListener {
            findNavController().navigate(R.id.action_to_profileFragment)
        }

        // คลิกปุ่มเพื่อเลือกภาพจาก Gallery
        binding.imageView3.setOnClickListener {
            pickImage.launch("image/*") // เปิด Gallery
        }
    return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
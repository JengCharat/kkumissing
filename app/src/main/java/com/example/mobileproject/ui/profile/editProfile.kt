package com.example.mobileproject.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentEditProfileBinding


class editProfile : Fragment() {
    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.undoBtn.setOnClickListener {
            //findNavController().navigate(R.id.action_to_profileFragment)
        }

    return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
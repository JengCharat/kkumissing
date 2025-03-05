package com.example.mobileproject.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        // ✅ ตั้งค่า RecyclerView
        binding.missingRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.asLostRecycler.layoutManager = LinearLayoutManager(requireContext())
        // ✅ สร้างรายการตัวอย่าง
        val itemList = listOf(
            SearchItem("กระเป๋าสตางค์หาย", "สมชาย", "ห้างสรรพสินค้า", "081-234-5678", R.drawable.rounded_button),
            SearchItem("โทรศัพท์มือถือหาย", "สมหญิง", "รถไฟฟ้า BTS", "099-876-5432", R.drawable.rounded_button),
            SearchItem("กุญแจรถหาย", "มานพ", "หน้ามหาวิทยาลัย", "085-123-4567", R.drawable.rounded_button)
        )
        // ✅ กำหนด Adapter
        val adapter = SearchItemAdapter(itemList)
        binding.missingRecycler.adapter = adapter
        binding.asLostRecycler.adapter = adapter


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


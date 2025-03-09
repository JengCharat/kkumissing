package com.example.mobileproject.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentProfileAsLostBinding
import com.example.mobileproject.ui.home.SearchItem
import com.example.mobileproject.ui.home.SearchItemAdapter

class ProfileAsLostFragment : Fragment() {
    private var _binding: FragmentProfileAsLostBinding? = null  // เปลี่ยนให้ถูกต้อง
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _binding = FragmentProfileAsLostBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.undoBtn.setOnClickListener {
            findNavController().navigate(R.id.action_to_profileFragment)
        }

        // ✅ ตั้งค่า RecyclerView
        binding.asLostItem.layoutManager = LinearLayoutManager(requireContext())
        // ✅ สร้างรายการตัวอย่าง
        val itemList = listOf(
            SearchItem("กระเป๋าสตางค์หาย", "สมชาย", "ห้างสรรพสินค้า", "081-234-5678", R.drawable.rounded_button),
            SearchItem("โทรศัพท์มือถือหาย", "สมหญิง", "รถไฟฟ้า BTS", "099-876-5432", R.drawable.rounded_button),
            SearchItem("กุญแจรถหาย", "มานพ", "หน้ามหาวิทยาลัย", "085-123-4567", R.drawable.rounded_button)
        )
        // ✅ กำหนด Adapter
        val adapter = SearchItemAdapter(itemList)
        binding.asLostItem.adapter = adapter

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
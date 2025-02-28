package com.example.mobileproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // ✅ ตั้งค่า RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        // ✅ สร้างรายการตัวอย่าง
        val itemList = listOf(
            SearchItem("กระเป๋าสตางค์หาย", "สมชาย", "ห้างสรรพสินค้า", "081-234-5678", R.drawable.rounded_button),
            SearchItem("โทรศัพท์มือถือหาย", "สมหญิง", "รถไฟฟ้า BTS", "099-876-5432", R.drawable.rounded_button),
            SearchItem("กุญแจรถหาย", "มานพ", "หน้ามหาวิทยาลัย", "085-123-4567", R.drawable.rounded_button)
        )
        // ✅ กำหนด Adapter
        val adapter = SearchItemAdapter(itemList)
        binding.recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
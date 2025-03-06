package com.example.mobileproject.ui.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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

        // โค้ดของ Spinner
        val items = arrayOf("ระบุตัวเลือก") + resources.getStringArray(R.array.spinner_items) // ใส่ "ระบุตัวเลือก" เป็นตัวแรก
        val type_search = ArrayAdapter(requireContext(), R.layout.spinner_item, items)
        type_search.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.TypeSearch.adapter = type_search

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

        binding.MAP.visibility = View.GONE // ซ่อนแผนที่ตอนเริ่มต้น
        binding.recyclerView.visibility = View.VISIBLE // แสดง RecyclerView ตอนเริ่มต้น
        var isMapVisible = false

        binding.ItemMapBtn.setOnClickListener {
            isMapVisible = !isMapVisible // สลับค่า true/false
            binding.MAP.visibility = if (isMapVisible) View.VISIBLE else View.GONE
            binding.recyclerView.visibility = if (isMapVisible) View.GONE else View.VISIBLE

            // Debug เช็คค่าใน Log
            Log.d("DEBUG", "MAP Visible: $isMapVisible, RecyclerView Visible: ${!isMapVisible}")

            // เปลี่ยนข้อความปุ่ม
            val buttonText = if (isMapVisible) "ITEM" else "MAP"
            binding.ItemMapBtn.text = buttonText
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
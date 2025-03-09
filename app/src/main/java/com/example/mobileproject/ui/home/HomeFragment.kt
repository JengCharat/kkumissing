package com.example.mobileproject.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // ประกาศตัวแปร View
    private lateinit var aboutus: ImageView
    private lateinit var chat: ImageView
    private lateinit var introduce: ImageView
    private lateinit var notifi: ImageView
    private lateinit var search: ImageView
    private lateinit var recyclerView: RecyclerView

    // ตัวแปรที่เก็บข้อความที่แสดงใต้ภาพ
    private val arrName = arrayOf("ของส่วนตัว", "อุปกรณ์อิเล็กทรอนิกส์", "เครื่องประดับของสวมใส่", "เอกสาร", "ของอื่นๆ")

    // ตัวแปรอาเรย์ที่เก็บรายชื่อภาพใน drawable
    private val arrImg = arrayOf(
        R.drawable.comlost1,
        R.drawable.comlost2,
        R.drawable.comlost3,
        R.drawable.comlost4,
        R.drawable.comlost5
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        recyclerView = binding.destinationList
        aboutus = binding.avatar
        chat = binding.chat
        introduce = binding.idea
        notifi = binding.bell
        search = binding.searchButton

        // ตั้งค่า LayoutManager สำหรับ recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // ตั้งค่า adapter สำหรับ recyclerView
        recyclerView.adapter = MyAdapter(arrName, arrImg)

        // เพิ่มการตั้งค่า listener ให้กับ aboutus
        aboutus.setOnClickListener {
            // เปิดหน้า Activity AboutUsActivity เมื่อคลิก
            val intent = Intent(requireContext(), activity_about_us::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

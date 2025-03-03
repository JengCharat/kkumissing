package com.example.mobileproject.ui.ReportMissing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportMissing6Binding

class ReportMissing6Fragment : Fragment() {
    private var _binding: FragmentReportMissing6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReportMissing6Binding.inflate(inflater, container, false)
        val root: View = binding.root

        // ปิดปุ่มแต่แรก
        binding.butNextTo7.isEnabled = false

        // ตรวจสอบว่า RadioButton ถูกเลือกหรือไม่
        binding.confirmMissing.setOnCheckedChangeListener { _, isChecked ->
            binding.butNextTo7.isEnabled = isChecked
        }

        // ปุ่มย้อนกลับไป
        binding.butbackTo5.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing6Fragment_to_reportMissing5Fragment)
        }

        // ปุ่มไป
        binding.butNextTo7.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing6Fragment_to_reportMissing7Fragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
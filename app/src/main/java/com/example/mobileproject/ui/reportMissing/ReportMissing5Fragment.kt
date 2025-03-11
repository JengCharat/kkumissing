package com.example.mobileproject.ui.reportMissing

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportMissing5Binding


class ReportMissing5Fragment : Fragment() {

    private var _binding: FragmentReportMissing5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReportMissing5Binding.inflate(inflater, container, false)
        val root: View = binding.root
        // ปิดปุ่มแต่แรก
        binding.butNextTo6.isEnabled = false
        // ฟังก์ชันตรวจสอบว่ามีข้อความทั้งสองช่องหรือไม่
        fun checkInputs() {
            val inputFnameNotEmpty = !binding.inputFacebook.text.isNullOrEmpty()
            val inputLnameNotEmpty = !binding.inputTel.text.isNullOrEmpty()
            binding.butNextTo6.isEnabled = inputFnameNotEmpty && inputLnameNotEmpty
        }
        // ใช้ TextWatcher กับทั้งสอง EditText
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {checkInputs()}
            override fun afterTextChanged(s: Editable?) {}
        }
        binding.inputFacebook.addTextChangedListener(textWatcher)
        binding.inputTel.addTextChangedListener(textWatcher)

        // ปุ่มย้อนกลับไป
        binding.butbackTo4.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing5Fragment_to_reportMissing4Fragment)
        }

        // ปุ่มไป
        binding.butNextTo6.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing5Fragment_to_reportMissing6Fragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
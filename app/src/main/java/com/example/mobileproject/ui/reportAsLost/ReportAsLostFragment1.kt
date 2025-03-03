package com.example.mobileproject.ui.reportAsLost

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportAsLost1Binding

class ReportAsLostFragment1 : Fragment() {

    private var _binding: FragmentReportAsLost1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentReportAsLost1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        // ปิดปุ่มแต่แรก
        binding.ButNextTo2.isEnabled = false
        // ฟังก์ชันตรวจสอบว่ามีข้อความทั้งสองช่องหรือไม่
        fun checkInputs() {
            val inputFnameNotEmpty = !binding.inputFname.text.isNullOrEmpty()
            val inputLnameNotEmpty = !binding.inputLname.text.isNullOrEmpty()
            binding.ButNextTo2.isEnabled = inputFnameNotEmpty && inputLnameNotEmpty
        }
        // ใช้ TextWatcher กับทั้งสอง EditText
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {checkInputs()}
            override fun afterTextChanged(s: Editable?) {}
        }
        binding.inputFname.addTextChangedListener(textWatcher)
        binding.inputLname.addTextChangedListener(textWatcher)


        binding.ButNextTo2.setOnClickListener {
            findNavController().navigate(R.id.NotificationsFragment_to_reportAsLost2Fragment)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
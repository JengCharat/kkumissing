package com.example.mobileproject.ui.reportAsLost

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportAsLost3Binding


class ReportAsLostFragment3 : Fragment() {
    private var _binding: FragmentReportAsLost3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportAsLost3Binding.inflate(inflater, container, false)
        val root: View = binding.root

        // ปิดปุ่มแต่แรก
        binding.butNextTo4.isEnabled = false
        // ฟังก์ชันตรวจสอบว่า EditText มีค่าหรือไม่
        fun checkInputs() {
            val inputLostPlacesNotEmpty = !binding.inputLostPlaces.text.isNullOrEmpty()
            binding.butNextTo4.isEnabled = inputLostPlacesNotEmpty
        }
        // ใช้ TextWatcher กับ EditText
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkInputs()
            }
            override fun afterTextChanged(s: Editable?) {}
        }
        binding.inputLostPlaces.addTextChangedListener(textWatcher)

        // ปุ่มย้อนกลับไป ReportAsLostFragment2
        binding.butbackTo2.setOnClickListener {
            findNavController().navigate(R.id.action_reportAsLost3Fragment_to_reportAsLost2Fragment)
        }

        // ปุ่มไป ReportAsLostFragment4
        binding.butNextTo4.setOnClickListener {
            findNavController().navigate(R.id.action_reportAsLost3Fragment_to_reportAsLost4Fragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
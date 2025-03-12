package com.example.mobileproject.ui.notifications

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportAsLost2Binding
import com.example.mobileproject.databinding.FragmentReportMissing2Binding


var item_name:String = ""
var item_type:String = ""
var more_detail:String = ""

class ReportAsLostFragment2 : Fragment() {
    private var _binding: FragmentReportAsLost2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReportAsLost2Binding.inflate(inflater, container, false)
        val root: View = binding.root

//        // ปิดปุ่มแต่แรก
//        binding.butNextTo3.isEnabled = false
//        // ฟังก์ชันตรวจสอบเงื่อนไขเปิด/ปิดปุ่ม
//        fun checkInputs() {
//            val inputReportMissingNotEmpty = !binding.inputReportasLost.text.isNullOrEmpty()
//            val inputMissingMoreNotEmpty = !binding.inputFoundMore.text.isNullOrEmpty()
//            val isSpinnerValid = binding.ReportType.selectedItem.toString() != "ระบุตัวเลือก"
//            binding.butNextTo3.isEnabled = inputReportMissingNotEmpty && inputMissingMoreNotEmpty && isSpinnerValid
//        }
//        // ใช้ TextWatcher กับ EditText
//        val textWatcher = object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { checkInputs() }
//            override fun afterTextChanged(s: Editable?) {}
//        }
//        binding.inputReportasLost.addTextChangedListener(textWatcher)
//        binding.inputFoundMore.addTextChangedListener(textWatcher)

        // ปุ่มย้อนกลับไป DashboardFragment
        binding.butbackTo1.setOnClickListener {
            findNavController().navigate(R.id.action_reportAsLost2Fragment_to_NotificationsFragment)
        }

        // ปุ่มไป ReportMissing3Fragment
        binding.butNextTo3.setOnClickListener {
            item_name = binding.inputReportasLost.text.toString()
            more_detail = binding.inputFoundMore.text.toString()

            findNavController().navigate(R.id.action_reportAsLost2Fragment_to_reportAsLost3Fragment)
        }

        val items = arrayOf("ระบุตัวเลือก") + resources.getStringArray(R.array.spinner_items)
        // ใช้ Layout ที่กำหนดเอง
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.ReportType.adapter = adapter



        binding.ReportType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position) as String
                // นำค่าที่เลือกไปใช้งาน
                item_type = selectedItem
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // กรณีที่ไม่มีการเลือก
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
package com.example.mobileproject.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportMissing4Binding
import com.example.mobileproject.databinding.FragmentReportMissing6Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReportMissing6Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReportMissing6Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentReportMissing6Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReportMissing6Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReportMissing6Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
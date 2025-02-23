package com.example.mobileproject.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportMissing2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReportMissing2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReportMissing2Fragment : Fragment() {
    private var _binding: FragmentReportMissing2Binding? = null
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        _binding = FragmentReportMissing2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        // ปุ่มย้อนกลับไป DashboardFragment
        binding.butbackTo1.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing2Fragment_to_dashboardFragment)
        }

        // ปุ่มไป ReportMissing3Fragment
        binding.butNextTo3.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing2Fragment_to_reportMissing3Fragment)
        }

        // โค้ดของ Spinner
        val items = arrayOf("ระบุตัวเลือก") + resources.getStringArray(R.array.spinner_items)
        // ใช้ Layout ที่กำหนดเอง
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.misingType.adapter = adapter
        val spinner = binding.misingType // ใช้ binding แทน findViewById
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
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
         * @return A new instance of fragment ReportMissing2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReportMissing2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
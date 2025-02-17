package com.example.mobileproject.ui.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportAsLost2Binding
import com.example.mobileproject.databinding.FragmentReportAsLost3Binding
import com.example.mobileproject.databinding.FragmentReportMissing2Binding
import com.example.mobileproject.databinding.FragmentReportMissing3Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReportAsLostFragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReportAsLostFragment3 : Fragment() {
    private var _binding: FragmentReportAsLost3Binding? = null
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
        _binding = FragmentReportAsLost3Binding.inflate(inflater, container, false)
        val root: View = binding.root

        // ปุ่มย้อนกลับไป DashboardFragment
        binding.butbackTo2.setOnClickListener {
            findNavController().navigate(R.id.action_reportAsLost3Fragment_to_reportAsLost2Fragment)
        }

        // ปุ่มไป ReportMissing3Fragment
        binding.butNextTo4.setOnClickListener {
            findNavController().navigate(R.id.action_reportAsLost3Fragment_to_reportAsLost4Fragment)
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
         * @return A new instance of fragment ReportAsLostFragment3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReportAsLostFragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
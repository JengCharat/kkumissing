package com.example.mobileproject.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportMissing1Binding


var fname:String = ""
var lname:String = ""
class ReportMissing1Fragment : Fragment() {

    private var _binding: FragmentReportMissing1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //
    private val binding get() = _binding!!
//test
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentReportMissing1Binding.inflate(inflater, container, false)
        val root: View = binding.root

    //    val textView: TextView = binding.textDashboard
    //    dashboardViewModel.text.observe(viewLifecycleOwner) {
    //        textView.text = it
    //    }

        binding.ButNextTo2.setOnClickListener {
            fname = binding.inputFname.text.toString()
            lname = binding.inputLname.text.toString()
            println(fname)
            println(lname)
            findNavController().navigate(R.id.action_dashboardFragment_to_reportMissing2Fragment)
        
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
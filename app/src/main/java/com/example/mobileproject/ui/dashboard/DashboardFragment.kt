package com.example.mobileproject.ui.dashboard
//test1234
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentDashboardBinding

var fname: String = ""
var lname: String = ""
class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null

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

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


    //    val textView: TextView = binding.textDashboard
    //    dashboardViewModel.text.observe(viewLifecycleOwner) {
    //        textView.text = it
    //    }

        binding.ButNextTo2.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_reportMissing2Fragment)
            var inputFname:EditText? = null
            var inputLname:EditText? = null
            inputFname = binding.inputFname
            inputLname = binding.inputLname
            fname = (inputFname?.text).toString()
            lname = (inputLname?.text).toString()
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
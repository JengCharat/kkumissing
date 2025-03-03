package com.example.mobileproject.ui.reportAsLost

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportAsLost4Binding

class ReportAsLostFragment4 : Fragment() {
    private var _binding: FragmentReportAsLost4Binding? = null
    private val binding get() = _binding!!

    private var imageMainSelected = false
    private var image1Selected = false

    private fun checkInputs() {
        binding.butNextTo5.isEnabled = imageMainSelected && image1Selected
    }

    val getImageMain = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                binding.imageUploadMain.setImageURI(it)
                imageMainSelected = true
                checkInputs()
            }
        }
    }

    val getImage1 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                binding.imageUpload1.setImageURI(it)
                image1Selected = true
                checkInputs()
            }
        }
    }

    val getImage2 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                binding.imageUpload2.setImageURI(it)
            }
        }
    }

    val getImage3 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                binding.imageUpload3.setImageURI(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportAsLost4Binding.inflate(inflater, container, false)
        val root: View = binding.root

        // ปิดปุ่มเริ่มต้น
        binding.butNextTo5.isEnabled = false

        // ปุ่มย้อนกลับไป ReportAsLost3Fragment
        binding.butbackTo3.setOnClickListener {
            findNavController().navigate(R.id.action_reportAsLos4Fragment_to_reportAsLost3Fragment)
        }

        // ปุ่มไป ReportAsLost5Fragment
        binding.butNextTo5.setOnClickListener {
            findNavController().navigate(R.id.action_reportAsLost4Fragment_to_reportAsLost5Fragment)
        }

        // คลิกที่ ImageButton เพื่อเลือกภาพ
        binding.imageUploadMain.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            getImageMain.launch(intent)
        }

        binding.imageUpload1.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            getImage1.launch(intent)
        }

        binding.imageUpload2.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            getImage2.launch(intent)
        }

        binding.imageUpload3.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            getImage3.launch(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
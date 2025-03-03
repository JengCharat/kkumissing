package com.example.mobileproject.ui.ReportMissing

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
import com.example.mobileproject.databinding.FragmentReportMissing4Binding

class ReportMissing4Fragment : Fragment() {
    private var _binding: FragmentReportMissing4Binding? = null
    private val binding get() = _binding!!

    private var imageMainSelected = false
    private var image1Selected = false

    private fun checkInputs() {
        binding.butNextTo5.isEnabled = binding.noImage.isChecked || (imageMainSelected && image1Selected)
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
            uri?.let { // แสดงภาพที่เลือกใน ImageButton
                binding.imageUpload2.setImageURI(it)
            }
        }
    }
    val getImage3 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let { // แสดงภาพที่เลือกใน ImageButton
                binding.imageUpload3.setImageURI(it)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReportMissing4Binding.inflate(inflater, container, false)
        val root: View = binding.root

        // ปิดปุ่มเริ่มต้น
        binding.butNextTo5.isEnabled = false

        binding.noImage.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // ถ้าเลือก "ไม่มีภาพถ่าย" ให้เปลี่ยนภาพเป็น add_image แทน
                imageMainSelected = false
                image1Selected = false
                binding.imageUploadMain.setImageResource(R.drawable.add_image)
                binding.imageUpload1.setImageResource(R.drawable.add_image)
                binding.imageUpload2.setImageResource(R.drawable.add_image)
                binding.imageUpload3.setImageResource(R.drawable.add_image)
            }
            checkInputs() // ตรวจสอบปุ่มถัดไป
        }

        // ปุ่มย้อนกลับไป
        binding.butbackTo3.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing4Fragment_to_reportMissing3Fragment)
        }

        // ปุ่มไป
        binding.butNextTo5.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing4Fragment_to_reportMissing5Fragment)
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
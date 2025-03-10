package com.example.mobileproject.ui.notifications

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportAsLost4Binding
import java.io.ByteArrayOutputStream
import java.io.InputStream

var img1:String = ""
var img2:String = ""
var img3:String = ""
var img4:String = ""
class ReportAsLostFragment4 : Fragment() {
    private var _binding: FragmentReportAsLost4Binding? = null
    private val binding get() = _binding!!
    val getImage = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                val img1_show: ImageView? = binding.imageUploadMain
                img1_show!!.setImageURI(it) // แสดงภาพที่เลือก
                //val base64Image = encodeImageToBase64(it)
                //ImageData.base64Image = encodeImageToBase64(it)
                //println("Base64: $base64Image") // สามารถส่งค่า Base64 ไปยัง Server ได้
                img1 = encodeImageToBase64(it).toString()
             
            }
        }
    }
    val getImage2 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                val img2_show: ImageView? = binding.imageUpload1
                img2_show!!.setImageURI(it) // แสดงภาพที่เลือก
                //val base64Image = encodeImageToBase64(it)
                //ImageData.base64Image = encodeImageToBase64(it)
                //println("Base64: $base64Image") // สามารถส่งค่า Base64 ไปยัง Server ได้
                img2 = encodeImageToBase64(it).toString()

            }
        }
    }
    val getImage3 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                val img3_show: ImageView? = binding.imageUpload2
                img3_show!!.setImageURI(it) // แสดงภาพที่เลือก
                //val base64Image = encodeImageToBase64(it)
                //ImageData.base64Image = encodeImageToBase64(it)
                //println("Base64: $base64Image") // สามารถส่งค่า Base64 ไปยัง Server ได้
              img3 = encodeImageToBase64(it).toString()

            }
        }
    }
    val getImage4 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                val img4_show: ImageView? = binding.imageUpload3
                img4_show!!.setImageURI(it) // แสดงภาพที่เลือก
                //val base64Image = encodeImageToBase64(it)
                //ImageData.base64Image = encodeImageToBase64(it)
                //println("Base64: $base64Image") // สามารถส่งค่า Base64 ไปยัง Server ได้
               img4 = encodeImageToBase64(it).toString()

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
        //binding.butNextTo5.isEnabled = false

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
            getImage.launch(intent)
        }

        binding.imageUpload1.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            getImage2.launch(intent)
        }

        binding.imageUpload2.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            getImage3.launch(intent)
        }

        binding.imageUpload3.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            getImage4.launch(intent)
        }

        return root
    }
    private fun encodeImageToBase64(imageUri: Uri): String? {
        return try {
            val inputStream: InputStream? = requireContext().contentResolver.openInputStream(imageUri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val outputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            val byteArray: ByteArray = outputStream.toByteArray()
            Base64.encodeToString(byteArray, Base64.DEFAULT)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
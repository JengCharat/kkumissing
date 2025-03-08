package com.example.mobileproject.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Location
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
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportMissing4Binding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.io.ByteArrayOutputStream
import java.io.InputStream

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReportMissing4Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
var img1:String = ""
var img2:String = ""
var img3:String = ""
var img4:String = ""
class ReportMissing4Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentReportMissing4Binding? = null
    private val binding get() = _binding!!
    val getImage = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                val img1_show:ImageView? = binding.imageUploadMain
                img1_show!!.setImageURI(it) // แสดงภาพที่เลือก
                //val base64Image = encodeImageToBase64(it)
                //ImageData.base64Image = encodeImageToBase64(it)
                //println("Base64: $base64Image") // สามารถส่งค่า Base64 ไปยัง Server ได้
                img1 = encodeImageToBase64(it).toString()
                println("img1111111111111111111111")
                println(img1)
            }
        }
    }
    val getImage2 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                val img2_show:ImageView? = binding.imageUpload1
                img2_show!!.setImageURI(it) // แสดงภาพที่เลือก
                //val base64Image = encodeImageToBase64(it)
                //ImageData.base64Image = encodeImageToBase64(it)
                //println("Base64: $base64Image") // สามารถส่งค่า Base64 ไปยัง Server ได้
                img2 = encodeImageToBase64(it).toString()
                println("img1111111111111111111111")
                println(img2)
            }
        }
    }
    val getImage3 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                val img3_show:ImageView? = binding.imageUpload1
                img3_show!!.setImageURI(it) // แสดงภาพที่เลือก
                //val base64Image = encodeImageToBase64(it)
                //ImageData.base64Image = encodeImageToBase64(it)
                //println("Base64: $base64Image") // สามารถส่งค่า Base64 ไปยัง Server ได้
                img3 = encodeImageToBase64(it).toString()
                println("img1111111111111111111111")
                println(img3)
            }
        }
    }
    val getImage4 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let {
                val img4_show:ImageView? = binding.imageUpload2
                img4_show!!.setImageURI(it) // แสดงภาพที่เลือก
                //val base64Image = encodeImageToBase64(it)
                //ImageData.base64Image = encodeImageToBase64(it)
                //println("Base64: $base64Image") // สามารถส่งค่า Base64 ไปยัง Server ได้
                img4 = encodeImageToBase64(it).toString()
                println("img1111111111111111111111")
                println(img4)
            }
        }
    }
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
        _binding = FragmentReportMissing4Binding.inflate(inflater, container, false)
        val root: View = binding.root

        // ปุ่มย้อนกลับไป
        binding.butbackTo3.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing4Fragment_to_reportMissing3Fragment)
        }

        // ปุ่มไป
        binding.butNextTo5.setOnClickListener {
            findNavController().navigate(R.id.action_reportMissing4Fragment_to_reportMissing5Fragment)
        }
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReportMissing4Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReportMissing4Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
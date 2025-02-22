package com.example.mobileproject.ui.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileproject.R
import com.example.mobileproject.databinding.FragmentReportAsLost2Binding
import com.example.mobileproject.databinding.FragmentReportAsLost6Binding
/*import com.example.mobileproject.ui.notifications.img1
import com.example.mobileproject.ui.dashboard.img2
import com.example.mobileproject.ui.dashboard.img3*/
import com.example.mobileproject.ui.notifications.NotificationsFragment
import com.example.mobileproject.ui.notifications.ReportAsLostFragment2
import com.example.mobileproject.ui.notifications.ReportAsLostFragment3
import com.example.mobileproject.ui.notifications.ReportAsLostFragment4
import com.example.mobileproject.ui.notifications.ReportAsLostFragment5
import com.example.mobileproject.ui.notifications.ReportAsLostFragment6
import java.io.IOException
import java.net.Socket
import java.net.URLEncoder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReportAsLostFragment6.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReportAsLostFragment6 : Fragment() {
    private var _binding: FragmentReportAsLost6Binding? = null
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
        _binding = FragmentReportAsLost6Binding.inflate(inflater, container, false)
        val root: View = binding.root

        // ปิดปุ่มแต่แรก
        binding.butNextTo7.isEnabled = false

        // ตรวจสอบว่า RadioButton ถูกเลือกหรือไม่
        binding.confirmFound.setOnCheckedChangeListener { _, isChecked ->
            binding.butNextTo7.isEnabled = isChecked
        }

        // ปุ่มย้อนกลับไป DashboardFragment
        binding.butbackTo5.setOnClickListener {
            findNavController().navigate(R.id.action_reportAsLos6Fragment_to_reportAsLost5Fragment)
        }

        // ปุ่มไป ReportMissing3Fragment
        binding.butNextTo7.setOnClickListener {
            println("fname")
            println(fname)
            println("lname")
            println(lname)
            println("item name")
            println(item_name)
            println("type")
            println(type)
            println("more detail")
            println(more_detail)
            println("lost place")
            println(inputLostPlaces)
            println("contact")
            println(contact)
            println("latitude")
            println(latitude2)
            println("longitude")
            println(longitude2)/*
            println("img")
            println(img1)*/
            post()
            findNavController().navigate(R.id.action_reportAsLost6Fragment_to_reportAsLost7Fragment)

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
         * @return A new instance of fragment ReportAsLostFragment6.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReportAsLostFragment6().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun post() {
        //println("encode imageeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
        //println(ImageData.base64Image)
        Thread {
            try {
                val postData = "sql_command=" + URLEncoder.encode(
                    "INSERT INTO items(fname,lname,item_name,more_detail,lost_place,contact,latitude,longitude,img1,img2,img3) VALUES('$fname', '$lname','$item_name','$more_detail','$inputLostPlaces','$contact','$latitude2','$longitude2','123','123','123')",
                    "UTF-8"
                ).trim()
                val host = "10.53.63.179"
                val path = "/myapi/kku-missing.php"
                // สร้าง HTTP Request แบบ Manual
                val request = StringBuilder()
                request.append("POST $path HTTP/1.1\r\n")
                request.append("Host: $host\r\n")
                request.append("Content-Type: application/x-www-form-urlencoded\r\n")
                request.append("Content-Length: ${postData.toByteArray().size}\r\n")
                request.append("Connection: close\r\n\r\n")
                request.append(postData)
                // แสดง HTTP Request ที่จะถูกส่งไป
                println("Request:\n$request")
                // สร้าง Socket ไปยังเซิร์ฟเวอร์
                val socket = Socket(host, 80)
                socket.soTimeout = 60000000
                // ส่งข้อมูลไปยังเซิร์ฟเวอร์
                val outputStream = socket.getOutputStream()
                outputStream.write(request.toString().toByteArray())
                outputStream.flush()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }.start()

    }
}
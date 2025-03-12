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
import com.example.mobileproject.ui.dashboard.img1
import com.example.mobileproject.ui.dashboard.img2
import com.example.mobileproject.ui.dashboard.img3
import com.example.mobileproject.ui.dashboard.img4


/////////////////////////////////////////////////////////
import com.example.mobileproject.ui.notifications.ReportAsLostFragment1
import com.example.mobileproject.ui.notifications.ReportAsLostFragment2
import com.example.mobileproject.ui.notifications.ReportAsLostFragment3
//import com.example.mobileproject.ui.notifications.ReportAsLostFragment4
import com.example.mobileproject.ui.notifications.ReportAsLostFragment5
import com.example.mobileproject.ui.profile.email2
import java.io.IOException
import java.net.Socket
import java.net.URLEncoder

////////////////////////////////////////////////////////

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
            if(img1 == ""){
                img1 = "/9j/4AAQSkZJRgABAQAAAQABAAD/4gHYSUNDX1BST0ZJTEUAAQEAAAHIAAAAAAQwAABtbnRyUkdC\n" +
                        "IFhZWiAH4AABAAEAAAAAAABhY3NwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAA9tYAAQAA\n" +
                        "AADTLQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAlk\n" +
                        "ZXNjAAAA8AAAACRyWFlaAAABFAAAABRnWFlaAAABKAAAABRiWFlaAAABPAAAABR3dHB0AAABUAAA\n" +
                        "ABRyVFJDAAABZAAAAChnVFJDAAABZAAAAChiVFJDAAABZAAAAChjcHJ0AAABjAAAADxtbHVjAAAA\n" +
                        "AAAAAAEAAAAMZW5VUwAAAAgAAAAcAHMAUgBHAEJYWVogAAAAAAAAb6IAADj1AAADkFhZWiAAAAAA\n" +
                        "AABimQAAt4UAABjaWFlaIAAAAAAAACSgAAAPhAAAts9YWVogAAAAAAAA9tYAAQAAAADTLXBhcmEA\n" +
                        "AAAAAAQAAAACZmYAAPKnAAANWQAAE9AAAApbAAAAAAAAAABtbHVjAAAAAAAAAAEAAAAMZW5VUwAA\n" +
                        "ACAAAAAcAEcAbwBvAGcAbABlACAASQBuAGMALgAgADIAMAAxADb/2wBDAAEBAQEBAQEBAQEBAQEB\n" +
                        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/2wBDAQEB\n" +
                        "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB\n" +
                        "AQEBAQH/wAARCADhAOEDASIAAhEBAxEB/8QAHgABAAIDAQEBAQEAAAAAAAAAAAkKBgcIAwUEAQL/\n" +
                        "xABTEAAABgIAAgQGDwYCBwUJAAABAgMEBQYABwgRCRIT1BUWVneVlhQXGBkhMTc4U1RXWJK1tiJ2\n" +
                        "lNHS1SN1JDIzNkFheCY5QlG3JzRFUnN0ssLx/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAA\n" +
                        "AAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AL/GMYwGMYwGMYwGMYwGMYwGMYwGMYwGMYwGMYwG\n" +
                        "MYwGMYwGMYwGMYwGMYwGMYwGMYwGMZ8Fe01hqcyTmxwLdQoiUya8vHonKYOXMpiKOCmAQ5hzAQ5h\n" +
                        "zDngfexmN+OVQ8qq36ci+9Y8cqh5VVv05F96wMkxmN+OVQ8qq36ci+9Y8cqh5VVv05F96wMkxmN+\n" +
                        "OVQ8qq36ci+9Y8cqh5VVv05F96wMkxmN+OVQ8qq36ci+9Y8cqh5VVv05F96wMkxmN+OVQ8qq36ci\n" +
                        "+9Y8cqh5VVv05F96wMkxmN+OVQ8qq36ci+9Y8cqh5VVv05F96wMkxmN+OVQ8qq36ci+9Y8cqh5VV\n" +
                        "v05F96wMkxmN+OVQ8qq36ci+9Y8cqh5VVv05F96wMkxmN+OVQ8qq36ci+9Y8cqh5VVv05F96wMkx\n" +
                        "mN+OVQ8qq36ci+9Y8cqh5VVv05F96wMkxmOluFSOIFJaK6Yw/EUs3GGEeXwjyAHQj8AfDn3klknC\n" +
                        "ZFkFU1kVA6yaqRyqJnLzEOZDkExTBzAQ5lEQ5gOB6YxjAYxjAZynxVcXWt+FOoFmbQKk/bpYihKj\n" +
                        "QYxykhLz7gn7J3LlyoRZKGgmhhKL+YcordQBBFizkHx0manQN6uUHrul2y+2Vx7Fr9NrsxZphcAA\n" +
                        "VCx8KwXkHJECCICs5VTQFJq3JzUcOTpIJFMooUo00d77suHEFs2ybQui5vZ826OEbFEVOqzrkEiY\n" +
                        "xYqvxwCIh2Ec17NNVYpSmfO+3eqFBRcSlDdm8uPPiQ3o9eFlbw/ptYXVOLanUV06gIluh1xFFJy8\n" +
                        "brBLyiqZB6h3D18btuZw7FNI/Yl44fOlZBUVpN0q/XMYyhlpBc7tc5jiImOZVydRQxjDzETCYREf\n" +
                        "jHJx+DDouK7bapBbV4jDSzhvYGjeXreso90vDJeCnRCLsZG3yLYU5VVR6iYjltCxriOIk3UTNIuX\n" +
                        "gLHZIy31/hV4bquyTYQekNaMm6XVMH/ZKIcLHUL1/wDGVcumyzhZce0P1llFTKG6wgJuQAABS77F\n" +
                        "l9E1/Al/LHYsvomv4Ev5Zdl9oDR/2R669UIPuWPaA0f9keuvVCD7lgUmuxZfRNfwJfyx2LL6Jr+B\n" +
                        "L+WXZfaA0f8AZHrr1Qg+5Y9oDR/2R669UIPuWBSa7Fl9E1/Al/LHYsvomv4Ev5Zdl9oDR/2R669U\n" +
                        "IPuWPaA0f9keuvVCD7lgUmuxZfRNfwJfyx2LL6Jr+BL+WXZfaA0f9keuvVCD7lj2gNH/AGR669UI\n" +
                        "PuWBSa7Fl9E1/Al/LHYsvomv4Ev5Zdl9oDR/2R669UIPuWPaA0f9keuvVCD7lgUmuxZfRNfwJfyx\n" +
                        "2LL6Jr+BL+WXZfaA0f8AZHrr1Qg+5Y9oDR/2R669UIPuWBSa7Fl9E1/Al/LHYsvomv4Ev5Zdl9oD\n" +
                        "R/2R669UIPuWPaA0f9keuvVCD7lgUmuxZfRNfwJfyx2LL6Jr+BL+WXZfaA0f9keuvVCD7lj2gNH/\n" +
                        "AGR669UIPuWBSa7Fl9E1/Al/LHYsvomv4Ev5Zdl9oDR/2R669UIPuWPaA0f9keuvVCD7lgUmuxZf\n" +
                        "RNfwJfyx2LL6Jr+BL+WXZfaA0f8AZHrr1Qg+5Y9oDR/2R669UIPuWBSfR7BBQqjfskVSj+woj1E1\n" +
                        "AEf/AJTE5GAR/wCQ5v7VnE7vnTMk3kaDs20RqaKiZ1Yh9JuZiBeppnKYW7yHk1XLNRA4F6pipkSN\n" +
                        "8RgOBilMFtN/w28P0oio3kdMa0doKpHQUTWp0GYp0lBKJyDyZgPI3VAOYCAgAmABADmAeFOIvoqt\n" +
                        "JbBg5GW0uyDU9+QROvHMo9ZZaizKqZVDFjpKCcHUCIFcRKk3kYRdkVqYCHdspBIvZlDIeCjpFaxx\n" +
                        "GrNddbDYsaRt9Nv/AKGRssIVi9gn/tFa97JUO6jZghOajuvulHQCQhncdIOCHUZsZNso6S8Tb9XX\n" +
                        "h9DyKchVrxQ7Eo1cFTUO3kYSwQbzkCiCxeqYirZyiVVBYn7ChOooTrJqBztpcEfEUbiW0HWrtKnb\n" +
                        "Eu8OotU9gNWwAmmFmhyJAMoihz6yLWwxyzGcSTAoItlnzqORUWBgZUwdc4xjAjh6VS1PK1whWRi0\n" +
                        "MqQtyt1PqbwyI9UfYSz1eeWIc4B1ipLGgE0VeqJRUIoKJhEipymrp8NVFabM4gtMUORS7eKsuxqu\n" +
                        "zmW/WEouINvJJSM4gAlEBAVodk9S6wDzJ1uv8IFEBsB9Lx81Bl52aX+XWbIV+j2+ehoL4Cj/ANpb\n" +
                        "B8BilMHw0G3fDyMAgBg+MpuXWIYAOUQMUBALdiaZEiESSIRNJMhU000ygQiZCABSEIQoAUpClACl\n" +
                        "KUAAoAAAAAGf7xmuttbRqml9d2nZl2eew67VI07931OqLl4uY5G7CLYJGMXt5GUfLN2DFAB5qOF0\n" +
                        "wHkXrCAZlMTUPXo5zLz0rHQsUzJ2juSlnraPYNic+XXXdu1EUEiiPIAE6heYiABzEQDOTZrj+4Q4\n" +
                        "KQUjXe7as4conMkuaOB/It0VCiqUxDuWjNRAwlMl1TdkdQAE6Y8+RhEK1XEzxZbW4n7Y6l7jMumF\n" +
                        "Sau3A1TX8e4URrteYHESJdo2TEhJWYWRAoyExIAu5WUEyLYWzFNu1S5hAAAOQByAPgAA+IA/8sC7\n" +
                        "Drbemn9voitrTY1UuBiEMdRpESzZWRSIQCic6sYoZOQTIn1igdQzYEyiIAJ+Yhz2vlF+AsM9VJdl\n" +
                        "YKxNStdnY1ZNwwmIV+5jZJmukYDpqIO2iiSxBKcAMAAfqiIftFHLLHR1cckhxExDvWO0nLc+3qsw\n" +
                        "F62nEm7ZgjfK6iKaR5JRk2BJq2sUcc5SzCDBugydImSkmrZqBnDdEJSMYxgMYxgMYxgMYxgMYxgM\n" +
                        "Yz8EbKxcy1B9DyTCVZCs5bA8jXjd81FwzcKNHaAOGqiqQrNXSKrZyl1+ug4SURVKVQhigH78YxgM\n" +
                        "YxgMYxgVlul118xqnExEW+NQKgnsvXsRLyoEIBCrWKuvpCtvHPMoFKJlYNnWiH+M5lUlVDmEVC5u\n" +
                        "3oXrU8Jad3UjrKjHuICtWzqD8KJXjSQcw/MvMORFDIPP2gIP+IBQFT/ZJ8vg9NEocdo6OSEwimSg\n" +
                        "21QpP+BTqWKMKoYP+ZipJgP/ACIGfl6GL5XtyebeH/U6OBYkxjGBFx0vHzUGXnZpf5dZshX6Pf56\n" +
                        "Ggv3lsH6CtuTUdLx81Bl52aX+XWbIV+j3+ehoL95bB+grbgW78hC6Z7YL1rWNNataOlEmU3NT95n\n" +
                        "G5B6gOhr7NCFgE1RDkZVuVaemXJ0BEUgdNWS5yCqg3OnN7kG/TQUJ6tC6T2g2QUUYRspY6JMLh2h\n" +
                        "iNnEy1bT1f6wF5kTIuEJYEzrHAhRVK1R64nVTIYID8YxgM3pwybAktYcQGorlGODtzsL5XGL8SCU\n" +
                        "Cqw05JtoWZQWKcQTOkaOfOD9VQQTBRNJURKKZTBovN3cNlCkNnb81FSo1sZ0eVvtbXekKTrkThom\n" +
                        "Tby82utzKYpEUopk6Exz8idYxCGMUTgOBdJAQEAEBAQEAEBAeYCA/CAgIfAICHwgIfHn9z+AAAAA\n" +
                        "AAAAAAAAHIAAPgAAAPgAAD4AAPiz+4DGMYDGMYDGMYDPzPXrONZupCRdtmDBi3WdvXz1dJqzZtW6\n" +
                        "ZlXDl05XOmi3boJEMossqciaSZTHOYpQEQxq932n6yqsvdr3Px1Zq8G2M5kpaTXKigkUPgTRTL8K\n" +
                        "jl24PyRas25FXLpYxEUElFDAUay3G10gdv4kH8hRaKpIVDSzVwZIseVZRtM3oETlEj+09icCpRp1\n" +
                        "SAuxrxTHRTJ2SsgZd0HURDorjl6TJ7a/DWo+HOXcxtZMZeMtGz2J1mknPJkMZJ3GVBbqpuI2KWEp\n" +
                        "knE6kZN6/biZNgZu3WOqpxVweca194VLMVAourTquaepqWykLOREyQnMBFp6srLGMSPnUSCKiiY9\n" +
                        "VnMFIDd8BVRReN+KcYF3TVe1qHumlRN/1zPtbDW5dPmm4QESOWTtMC+youUZn5Lx8oxUN2TtmuUp\n" +
                        "0zcjkFRBRJVTYmU3uGDim2Pwt3hKzU52o/rsis3TuVIeOFAhbPHpdYnMyfMSsZlqmoc0bLoFKuio\n" +
                        "BUXPshkZVse1noLiB1xxHUNpe9dSxXSH+E2nYNydMk5Vpc6JVlImbZkOYUVgKInbOSCdo/QDt2iq\n" +
                        "hQOCYbuxjGAxjGBXi6aH5VdIeb60/qNhnh0MXyvbk828P+p0c9+mh+VXSHm+tP6jYZ4dDF8r25PN\n" +
                        "vD/qdHAsSYxjAi46Xj5qDLzs0v8ALrNkK/R7/PQ0F+8tg/QVtyajpePmoMvOzS/y6zZCv0e/z0NB\n" +
                        "fvLYP0FbcC3fmrt0akqm89ZWzVtzbdvB2mO9jGWIBfZMZItlknsRMMTmAeyfRMm3avm5w5dY6PZH\n" +
                        "5pKKFNtHGBTQ4j+GLaHDJc3NZvsK7GEcuXPipd2zVY1ZtbBIeuVRjIgQWyUo3QOkaVhFVSyEcZRM\n" +
                        "6qItV2rhbnbLzljrNct8Q6gLXBRFkhHpeo7iZuPayceuHIQAVGrxJZETk6wimp1AUTMPWTMUwAOc\n" +
                        "bTfRv8Hk4/PIH1KzjDqdcVG0NLzMexOdQxTGU9iEenSIcBKPUBMCEIB1CkKUpuQBU6i4uTnJJlDw\n" +
                        "kbITMvJuEmcbExLJzJScg7WOCaLViwZJLu3bhU5ikTQboqKnMIFKURHLJ/RwcDsloWNcbd2qxI12\n" +
                        "raIz2DEV45k1VaJXXXVUctnyqZlEjWOXEqXhFNuodGOapJsO0WcGcmJ3bqrhu0XpIyi2r9ZVeqPl\n" +
                        "SdmrLtWZnc2cgpmTUJ4ZklHkmkksUxgXQRdJILcw66QgUoF3dgMZ+R8/YxbJ1JSb1pHRzFuq7fP3\n" +
                        "zhFoyZtUCCou5dOnB00G7dFMplFVllCJpkKJjmAoCOfKqtsrF5r8ZaqbYIe0VqZbg6ip2CkG0nFv\n" +
                        "kBESidu8aKKonFM5TJLJ9ftEFiKIrEIqmchQyDGMYDGMYDNJ764gNa8OVGdXnZE2kwbj2reDhUDp\n" +
                        "qTtolSJgckVBR4mBV2v+0Q7tx1QaRzYwu36yCBesOpuLbjP1rwqVsPC6ydk2RMNFVanr6PcE8IOg\n" +
                        "DmQsxPKlEQg66it+yLtz1XMkqRVrEIOlEHirKrXu7emx+IS8vb7sqcWlZNXtW8XHpmOnDVuKOqKq\n" +
                        "cPAsBMZNiyTN1TKiUO3ergLp4osuPWANpcV3F3sjiqtoSFicqwtGh3ChqfQWTg4xMQUQMmMnIcuq\n" +
                        "ErYHKQ9VeRcFErVL/RY9NukK5nPJ2MYDGMYDNx6L3tsXh3vzDYGuJlSPkEQI1mItYx1IWzw/aAot\n" +
                        "DTzEDFTdtTjzUbK/suo9z1XTJZFUDdfTmMC4lwscWet+KinDNVV0SKtsQg2C5UV64TGZrzlcOqVy\n" +
                        "mX9gZGDdqlOVhLtyCgoch2q4IPElUC9TZSE1ls67aeusNsHXs66r9nhFRM2eNjCKTlqqJPZcZIth\n" +
                        "EEn8W/IQqbxi4AyKoFTUACLooLJWkuDHjfo3FRXyw7pRrWdvQbAq9lpiyvUCRbJCRJWx1ZRXqhJx\n" +
                        "B1TE9mt0jHewayyKMgkRBywdPA7pxjGBXi6aH5VdIeb60/qNhnh0MXyvbk828P8AqdHPfpoflV0h\n" +
                        "5vrT+o2GeHQxfK9uTzbw/wCp0cCxJjGMCLjpePmoMvOzS/y6zZCv0e/z0NBfvLYP0Fbcmo6Xj5qD\n" +
                        "Lzs0v8us2Qr9Hv8APQ0F+8tg/QVtwLd+MYwGMYwGa82jtWg6Zp0pfNkWNlWq3EpCZV06MY7h24Eo\n" +
                        "ihHRbFEDu5OTdmDsmjBmkq4WUH4CAUDGLpnii4vNWcK9YCSt7wZm3SaKg1agRC6Iz86qXmX2St1u\n" +
                        "uSIhEFOQPJl6QEU+YItUnr06TRSrpxFcTW0uJq4q2nYUsJWDZVXxcqEcqunWas0U/ZBCMZqKG7V0\n" +
                        "ZMAI6lHPXfvBARVUAo9mAdEcZXSA33iZePqlWAkKPppJyYratgsQkzak0VAFCQuDlqcxDAqJCrpV\n" +
                        "9sstHMRMVNZeRWTF0fVPCvxjbR4WLGReuulLBQpB2Raz68kXSicVJlMZMq72LWEq3gWcBEogjIIo\n" +
                        "qpKG5EetnCQmDOScYF0Dh/4j9WcSlNRuGtZwHQpFSSnq3IAm0s1XkDplOZhNxgKKGSEOt/o75so5\n" +
                        "jHxAFRk8XApwJvjKSWptvbC0hc42+a1sTyvT8coTriiYVGEo0A3WVjJqPOPsaUjHAcyrNHJDF5GE\n" +
                        "6RklQKoFm/g+4+9ccTUWnAzR2VC21HNO0l6k+eFJHzSbdHruZmoP3RkxfsORVFXUaqIycQH7LkHD\n" +
                        "YUH7kO/sjF43OkSqXD63kdc60VY3Dcq6CiDoUzkc1/XwKp8iu55YgmTfTv7XWY1xAwmRMUXM0ozR\n" +
                        "K3aSXOnHR0maUUM1p7hxlSOJQAVjbVtVkqmq1jTgJk3cVSVCGMR0/T5Cg7sBgM1anFVKNKs4T9lp\n" +
                        "QJuXLl65cvXjhd28eLqunbtyqou5dOlzmVXcuV1THVXXWUMZRVZU5lFDmMc5jGERwPv3G5WnYNml\n" +
                        "7jdJ2RslmnXZ3kpMSjhRy6crHEeqUDKGN2TdEvJJs2S6qLdEpUkiFIUAzGcYwGMYwGMYwGMYwGfe\n" +
                        "q1osNJsUNbanMPoCx198jJREvGrmbvGTtAR6qiahfgEpyGOkskcDJLoKKIqkOmoYo/BxgWheBTpA\n" +
                        "IDiMZtdb7DO0rm6o1kBkiBybw+wWbVMRcSUAJjGBtNNSE7WXgFTAoKZvCMSZ20K/RipM8qO9Hf8A\n" +
                        "PD0z/nEp+QSmW4sCvF00Pyq6Q831p/UbDPDoYvle3J5t4f8AU6Oe/TQ/KrpDzfWn9RsM8Ohi+V7c\n" +
                        "nm3h/wBTo4FiTGMYEXHS8fNQZedml/l1myFfo9/noaC/eWwfoK25NR0vHzUGXnZpf5dZshX6Pf56\n" +
                        "Ggv3lsH6CtuBbvxjPyP37GLZO5KTeNo+PYN1Xb189XSbNGjVAgqLuHLhYxEkUUkymOoqocpCFATG\n" +
                        "EADA/XkX/Gr0jlR0ASQ13q7wdeNwnRWbvFO1BxWNfqHKBCrzqqIiWUnSAcVWtbaqh2RkwVm3LJIy\n" +
                        "DV/yLxt9J+8mTSuqeGiTUYxAC5j7PthADpyEmXkKKsbRSnKQ0czAQOV1ZViqPHZTAlEJMCJjIOoR\n" +
                        "lllnKyrhwqqu4XVUWXXWUMqsssqcTqqqqnEx1FVDmMdRQ5jGOcwmMIiIjgZRer3b9l2qWu17n5Gz\n" +
                        "WibX7eRl5NYVnCvITdk3SKAFSbM2xTCm1ZtiJNmyfMqSRQE3PEsYwGMYwGeqC67VZNy1XXauERMK\n" +
                        "Thsso3XSE5DpHFJZExFUxOkookcSGKJkznIbmUxgHyxgAAADkAcgD4AAPiAP/LGMYDGMYDGMYDGM\n" +
                        "YDGMYDGMYHa3R3fPD0z/AJxKfkEpluLKjvR3fPD0z/nEp+QSmW4sCvF00Pyq6Q831p/UbDPDoYvl\n" +
                        "e3J5t4f9To579ND8qukPN9af1Gwzw6GL5XtyebeH/U6OBYkxjGBFx0vHzUGXnZpf5dZshX6Pf56G\n" +
                        "gv3lsH6CtuTUdLx81Bl52aX+XWbIV+j3+ehoL95bB+grbgW78gz6ZDY14hiar13D2WTi6baYyfl7\n" +
                        "LBx6pWqE88jXrFuwLKrIkK7dsmxF1TkjVFxj1FxI4WbKroIKJTmZX96aL/fLRv7s2381jMCEnGMY\n" +
                        "DGMYDGMYDGMYDGMYDGMYDGMYDGMYDGMYDGMYHa3R3fPD0z/nEp+QSmW4sqO9Hd88PTP+cSn5BKZb\n" +
                        "iwK8XTQ/KrpDzfWn9RsM8Ohi+V7cnm3h/wBTo579ND8qukPN9af1Gwzw6GL5XtyebeH/AFOjgWJM\n" +
                        "YxgRcdLx81Bl52aX+XWbIV+j3+ehoL95bB+grbk1HS8fNQZedml/l1myFfo9/noaC/eWwfoK24Fu\n" +
                        "/K/vTRf75aN/dm2/msZlgLK/vTRf75aN/dm2/msZgQk4xjAYxjAYxjAYxjAYxjAYxjAYxjAYxjAY\n" +
                        "xjAYxjA7W6O754emf84lPyCUy3FlR3o7vnh6Z/ziU/IJTLcWBXi6aH5VdIeb60/qNhnh0MXyvbk8\n" +
                        "28P+p0c9+mh+VXSHm+tP6jYZ4dDF8r25PNvD/qdHAsSYxjAi46Xj5qDLzs0v8us2QsdHsAm40NBA\n" +
                        "UBEfGSwjyABEeRaDbjGH4P8AgUoCYR+IAARH4AycLpYoF5M8Iso8a9fsazfqXPyAlTE5SshXfwfN\n" +
                        "Qwf7EnsybaB2o/B1xImPIFOeV+OEy4tKBxNaKtsi5IzjYzZVbbSb1VTs0mcXOuvF2TdrHEQAqDZh\n" +
                        "LOF1xMPIESKfAPwAIXM8r+9NF/vlo392bb+axmWAs4+4neC3WXFXJ1SVv8tao1xUGElHxxK8+bNE\n" +
                        "lUZNw3crmclXauBOoQ7YgJiUxQApjBy5jzEKhGMsqe898OHlTsz0zHf23HvPfDh5U7M9Mx39twK1\n" +
                        "eMsqe898OHlTsz0zHf23HvPfDh5U7M9Mx39twK1eMsqe898OHlTsz0zHf23HvPfDh5U7M9Mx39tw\n" +
                        "K1eMsqe898OHlTsz0zHf23HvPfDh5U7M9Mx39twK1eMsqe898OHlTsz0zHf23HvPfDh5U7M9Mx39\n" +
                        "twK1eMsqe898OHlTsz0zHf23HvPfDh5U7M9Mx39twK1eMsqe898OHlTsz0zHf23HvPfDh5U7M9Mx\n" +
                        "39twK1eMsqe898OHlTsz0zHf23HvPfDh5U7M9Mx39twK1eMsqe898OHlTsz0zHf23HvPfDh5U7M9\n" +
                        "Mx39twK1eMsqe898OHlTsz0zHf23HvPfDh5U7M9Mx39twIgeju+eHpn/ADiU/IJTLcWR16Z6NLSO\n" +
                        "kNk1nZ9VsF7dztWcrumDeWk2Lhgqdw0XZnK4STYJHMXs3BxDqKFHmAfDy55IpgV4+miAfbU0ebkP\n" +
                        "VHX9qAB5DyEQsceIgA/EIgBiiIfGACHP4wz8/QxfK9uTzbw/6nRzFemHujKc4hqVTmbgFz0TWjQ8\n" +
                        "mUogIM5e2TUjInZmD4yreBWEC+P/AMDIvmw/GUc2H0L8C+Uvu7LOUDDGtqjXIBQwEESA/eTC0kkU\n" +
                        "ynLkUwtmSglJ1h64AcQAOzHmFgvGMYGutu64h9v6wvmsJ4QJGXiry1eVc9mCp49w+aqEYSyCZhAp\n" +
                        "nUPIA1lGYG/ZB0zREwCUBAaYexteW/Ul5sevLtHqRFrqcmtGyKRBN2Kh0Tc20nGrmABcRsih2T+M\n" +
                        "dgAds0WROYqanXTJeBzgPja4FqxxUwqc/BPGNS3DBMzIQVmdIqmiZxmmU5k69aytU1XfsEyglFnL\n" +
                        "NEXL6IOJjkZyDYyjFQNBcFnSV62uFRr2ud8WVrR9iQjJpDtLVYFPY1Yurdokm2aOl5wwexIewHSK\n" +
                        "Qj1CYUZt5FwHbsHbhy4UaJSwR9jr0s2Sexc7DyLNchVEXTGSZum6iZ+fVORVBY5DFMJTAAgb4ymD\n" +
                        "4wEAph7e4f8Ab+iplzCbQos1XDIqqJJSp2p3lckSFP1CuI2falVi3jZYRDsjEcFUETdmokmsU6Rd\n" +
                        "WR8zLRZOpEy8pGpCcVOpGyTximKn7YCoJGi6RBUHrnAT8usIGMAjyEcC854Rj/rzP+JQ/rx4Rj/r\n" +
                        "zP8AiUP68o7eONw8rrT6xTPfceONw8rrT6xTPfcC8T4Rj/rzP+JQ/rx4Rj/rzP8AiUP68o7eONw8\n" +
                        "rrT6xTPfceONw8rrT6xTPfcC8T4Rj/rzP+JQ/rx4Rj/rzP8AiUP68o7eONw8rrT6xTPfceONw8rr\n" +
                        "T6xTPfcC8T4Rj/rzP+JQ/rx4Rj/rzP8AiUP68o7eONw8rrT6xTPfceONw8rrT6xTPfcC8T4Rj/rz\n" +
                        "P+JQ/rx4Rj/rzP8AiUP68o7eONw8rrT6xTPfceONw8rrT6xTPfcC8T4Rj/rzP+JQ/rx4Rj/rzP8A\n" +
                        "iUP68o7eONw8rrT6xTPfceONw8rrT6xTPfcC8T4Rj/rzP+JQ/rx4Rj/rzP8AiUP68o7eONw8rrT6\n" +
                        "xTPfceONw8rrT6xTPfcC8T4Rj/rzP+JQ/rx4Rj/rzP8AiUP68o7eONw8rrT6xTPfceONw8rrT6xT\n" +
                        "PfcC8T4Rj/rzP+JQ/rx4Rj/rzP8AiUP68o7eONw8rrT6xTPfceONw8rrT6xTPfcC8T4Rj/rzP+JQ\n" +
                        "/rx4Rj/rzP8AiUP68o7eONw8rrT6xTPfceONw8rrT6xTPfcC8KrLxKBTHWk45EhSmOY6r1smUpCi\n" +
                        "UDHMY6oABSicoGMI8gExQEeYhz4w4juPrQfD/CyKIWuLvmwioKEiKFUnqMs9O8EDlSVnn7M6sdXo\n" +
                        "1JQoGcKSDtF6umBiRrN4tzKWp+6sdjfJmSfWGeepHIKZ0nczJOUjpm/1kzprujkOQ3/iIYolN/xA\n" +
                        "c/bTqPbb5KtoCi1abtUs6VTRQjq9FuZJcVFBApAOVokciJeXw9dUyZAKUR58ijyD62ytg2nb+w7T\n" +
                        "sW1rmkLTdpxWUfggU5ygu4FNsxjWCIAY4NWDRJpFxjUhRFNo2bIJl/ZAMtHdHdw7yPD3w8xDS0sv\n" +
                        "YF/v7013t7M5Q9kxAvm6KEDXHJwMIC4h4ZJuZ+n1QBtMvpVsU6yaSa6nJfAt0aC+vJWK3BxDNIx7\n" +
                        "bWJ0n9P1wmonJMqw7TMB281aXaYnYP55EwdoxiWQvI+LEEXTh85fmOzj5osBjGMBjODOPrie2lww\n" +
                        "UTXMzqGm1m9XHYGzIfXsfX7MhMOEnrqbRWKwaxxIWWiHHhJ6/BuzbdqsqiJ1wAUTCICGzoPiXib9\n" +
                        "wjzHE5rxBk7Fvp627AYwsmdZZsxstXq8nKu61NC1O0dCRhNxyka+FIzRyqgQVkhbmVTEodKS0PEz\n" +
                        "zFaMm4uPmI5wAlXYSbNu/ZrAJTFHtGzpNVE/7JjAAmIIgBh5CHMc5+luDvhXnHJncvw/6pfuTmMc\n" +
                        "yrimw5jCY48zCAA2KUOY/DyAAABERAAEw8/scOO25DbvDzq/ctwRhK/IXOjx9rnko867OAi1HCSi\n" +
                        "rsW6ko8drtmCBExOJ3r5YyZAMZRcQARzIqbvfS+xJx3WaLtKiW2wsQWF1CwNmipKSTK363bmK0bO\n" +
                        "TrKlRAhjqmRIoVNMO0OIJiBhDWPuIOEL7uGofUuI7vj3EHCF93DUPqXEd3zqbOPh4h7aXjl9zAMN\n" +
                        "XBpI8PjbbYTvZSYWkJ9a3yNeNHCt4RGJGHBoyKsUgRYPQcnMIvBS5JgH2/cQcIX3cNQ+pcR3fHuI\n" +
                        "OEL7uGofUuI7vm27TufUdJYP5O27MotfYxcsMDJOJO0Q7YrCbKQFTxDwpnfXbSaaRiqqsViEcpJC\n" +
                        "CqiZSD1s/wAzG6dRV+oRd/nNmUaKpM4ADC2l9Z4dCDl+YmKJIyQO7Bu/UIYihFUmp1VUjpqEVIQy\n" +
                        "ZwKGpvcQcIX3cNQ+pcR3fHuIOEL7uGofUuI7vnRMJZ63ZYFpaa9PRE3Wn7QX7Kei5Fo9iHLIoGMd\n" +
                        "ylIN1VGpkUwIcFT9ryRMRQqvUMQ4BrOP4jtAy1nJTIvc2s5G0qrC3Sg2VzgXL9VwBuoDdJJJ8cFF\n" +
                        "zKf4ZESGMoooJUyFMcxSiGBe4g4Qvu4ah9S4ju+PcQcIX3cNQ+pcR3fOlpWWi4KOeTE3JMYiJjkD\n" +
                        "un8nJu0GLBk2TDmdd28dKJN26JPg6yiqhCBzABHmIZresb40pdGC0pVdsa9nY9vINIld2wtsIqij\n" +
                        "KPzqJMI9QwvS9R4+VSVTZtxAFXSiShECqGIYADWPuIOEL7uGofUuI7vj3EHCF93DUPqXEd3zoK2X\n" +
                        "Kp0OFcWO62WDqcC1MRNxMWGTZxMckooBhTSM7erIo9qoBDiRIDiocpDiUogQwh8qh7N13tGMWmdc\n" +
                        "3asXeLbLFQcvazMsZhFssfrimm5FmsqLc6oJnMkCwE7UpDGT6xSiIBpL3EHCF93DUPqXEd3x7iDh\n" +
                        "C+7hqH1LiO751Nkc3HPxm37humaDUdP0OE2TcpKBt20tgxEsEmoauaboiSATcyzSi5CNULMSjtdw\n" +
                        "3glHKrpqY8NJpHYOVBS6gbz9xBwhfdw1D6lxHd8e4g4Qvu4ah9S4ju+bqgdlUydo9Q2CWxwjGs3a\n" +
                        "Kr0pAykhJs2DJ+WzNWzmJbNXLxZBNZy8F0ki2bkMK66xipJkMcQLmYv5BhFMnMlKPWkbHMkTuHj9\n" +
                        "+5RZsmjdMOsou5dODpoIIpl/aOqqoQhA+ExgDA5k9xBwhfdw1D6lxHd8e4g4Qvu4ah9S4ju+bos2\n" +
                        "1dZ02vMrbar/AE+ArEm2SeRc9KWGKaxUo0XRI5QdRj1R0CEg3WbqJuE1mZ10zoHKsUwpmAw+tF2d\n" +
                        "rrZ8erK66vFWu0cgcE13dYnI+ZSbnMHMpHAsV1jIGMHPqgqUgm5D1efVHkGkvcQcIX3cNQ+pcR3f\n" +
                        "HuIOEL7uGofUuI7vmX0SY2gvtbdrC12TX0rRIlxWDa3gq64RUuNearwCS8yne2yax10F38qKziKF\n" +
                        "YiQKRwInSDkJxzVvBVve1bq4eS7V2nIwDSSSuGx4x/INWyMDDMoWp2mTiGaznt3KiCAIsGRVHjtV\n" +
                        "dNMTddQ4EKAjgZH7iDhC+7hqH1LiO749xBwhfdw1D6lxHd82LWeITRdzsRqjU9u67sVmA5kywcPb\n" +
                        "YV/JKqFHkZNu2buzncnD4wK3BUwhzEAEA55pTiV3ldNU7l4Q6dXXkMzrG4tm2ar340oxScLGhYqt\n" +
                        "JyzYzB8qukWKVSc9cyzkSqAdIeqYCgXrYGWtuCnhJaLEcNeHbUqC6fPqKpU2JIcvMBAeRgQ5h8Aj\n" +
                        "/wD3N51Wh0qitPYFMqddqzTqFTFCBiGMWQxC9XqkP7DQSFQodUogBxMACAD8fw58Cmbm1JsSVk4O\n" +
                        "h7KpFwmIYTBJxdcssTLPmYEMJDnVbMnSyopJnKJFFiFOkmYQKc5TGKA6Fhd23l/x4XXh7XViva6g\n" +
                        "OGitbSYIkjgLM+NcrsBzXXaq8oKxjKsPBqRCpMgQIUi3NUTmEeQB2LjNY3vdOo9XuWLLYuyqTSns\n" +
                        "n1RYMrJZIuJeOiHMcpFUWjtym4MgY6ZyFX7MEROQxAU6xRAM+ipaLnY5nMQkkwmImRQI6YScY7Qf\n" +
                        "R71sp/qLtHjVRVu4RPyHqqJKHKIgIc+YDgfQxjGBGd0i/wDvFwI/9dPD/wDrSJzQ2zDDwlXLir0Q\n" +
                        "4AWOleKrTG9Nn6W58yRla22215PvdjUFoc5zJtkbGiQ1lhGBRIHssHbZEvN0zbhJFvzh5it9P9Kv\n" +
                        "5SySFeNpfdFG3NHJsGTZ4WckaPLtZdtCPTOFUxasn6jUEV3SAKLpEOJkyGMAAPyOLXhYpfFzqpTW\n" +
                        "tskXtceM5qNsNYuUQ2QcTdXlmKvZuVmBVlESqoSkSs+iX7U66aKqLsq5gMu0bCQIuLy/fvujq6Pb\n" +
                        "V6sq8g6Ru7ZmidY7OfsnSrJVzR5M8zJyEGo8Q6qrdtLOYtoZ0KZyGcNmarI/XQdLkNvrpCdF6e0t\n" +
                        "w5Q249SUir6r2Toq/amf60sVFhY2uTA+E79XKlIVd27jm6LqYiZWHmni7qPfKOiLSDNrJLFUWbnO\n" +
                        "frN/wba1sXCzWuFW4vZedq9ThIRhB2tkckFaoecrLoXtet0I5aGXTi5yKdgVRIU+2aroi4YvEHEe\n" +
                        "8dNVdVteBa1W6doqvEdxSbN4iKLrOdZ2moa3n6xSadBuLJFAYkLL3iRqjBvL35xEkUVM3GecmOdw\n" +
                        "odVRUU3D1B2HfUI8WkYaIkHKXYuH0YweOEeQl7JZ00SXVS5GADB2ahzE5GABDlyEAHI1T/8Ae7l/\n" +
                        "6KGP/qbPZJ7nOQ8OkQPFR7qUbLI+GvaeR1AFTBk2CLBijZHtiCaGQ7UXYuzKPTtRagiCIEIVXtRN\n" +
                        "zIIcLcHmjdW33iH4/wC73umQF1lY/igstWhm1qi2c7FQjJWDiJKWdRcZJIuWLaTnTvGrWVkSt/Zi\n" +
                        "7GKYsyrEb+yU1/kcCnD7qKQ2hxmQ85SoWy1jVPEZcqNqyo2dmlYKrrmtSwjNzUdT4CVK6jIcsw7c\n" +
                        "t036zdsDlZrHtG4r9mLgF5DdKaCjNLWbe1lj7E+nFd6bYktryTV4xbtE4B9IxkfFniGKiCypnjRJ\n" +
                        "KOSUK4XKksZQ6gCQC9UC/wCNJcP0XpW072tEdY5CdX3ptOR2lJNHrJs0SgHsg1SamiWKiCqh3jVI\n" +
                        "qQHK5cAmqYTchIABzEOB+E6zULR1F6ROAsyHsPRWld+bT9gVRokdRnDU6VjjOJCqwjQqhDIsV+sS\n" +
                        "OjmKa6KCRligB0euqqOjt4UyyXrhBu1vheAvh01Hq0urJDYFKsCmw4qD2fTotCCPYaxaI2NquuUE\n" +
                        "Yy0t0vYbtOBStSfstyr4HdyIkcrjkmlZ4P6NFR3FHA2KYk7XXeKm42C2W2LWboRh4IlhYGYLx0Q8\n" +
                        "bqLnVM06xXTJ+ukVRNykkcyBylEptAOOjyudi1i50ZsPjD3DeNKM60vW6pQVazRa+pFoNGBmdTCz\n" +
                        "W6Ejm9tvMdUlSMX7OElpZvGvnEYwSfJHYoexDBpfes5Jbk1T0XGvdlSjmRpXEHaNYONykWcrNkbw\n" +
                        "rF68ibQzgJxdFRNVZpb7CItJBoVdL2ao7EEgKsVEyX6+kj0NpikVjhuudLpNUolmY8T+lqsiSpxL\n" +
                        "CuIzteeS7ldWLk4+IQaISqUQrHtX0Yo8SW8ECDorUyQP1SqdOcQuldFVXhCpeutz2K2RtO05H62j\n" +
                        "K1terNHiF3o9mqCUdC1rYUYaFbyK0Yu0coJryRyNnbFu1WXOuUpEU3beMWyx1T4lti8PWv8AXHE3\n" +
                        "trjSvcFuqiWuUuclBt4LW2mNW1Z8eWt0g/bwNfgoVe2zabSPYoSs4tJTL/2MWNaqtjvFCOQ6U4kp\n" +
                        "Cy7A6Q+AosrpdzxC1DUehwv9S1M6sMHCVkbVYLJHRb/YcvG2cww1lcQKCyUOzbKoOQYvXsdIkTSc\n" +
                        "x6Kw5zrLV+32nGLrPb1O4X0uG+jPandKbvVrHWymrQd1j1ovwjRpJSu1UE2xpyDsbJFM0qduD1Vo\n" +
                        "ugzBb2OLnOu+IDhWhN12Om7Lrl6t2mt2a8SdsqftiiCwWlm8LImE0lWbBCy6DmGtNaeHMdY8RKIC\n" +
                        "iDgxjdYyCrps48dUaF3ZU7wyum2OLrZO6UouPkWMfT1KTrnWlMUVkUQbmkJqHokKyPPPGZOsrHGf\n" +
                        "OuzZuTAumTmQpcDq8xikKY5zFIQpRMYxhApSlKHMxjGHkAFAAERERAAAOY/BkE2q+I3Xts4lOLHe\n" +
                        "ux9dbwvMBbki8PWpnNB05eb5Wyalpx5KOt5kZmAjnjBJzaLSo5VfNE3Rlmbhq+D9lN51CzW32tvr\n" +
                        "jSbZU42ec1d9Za9LQbaxs2qT53CqSjJZkEk2aLqIouF2oLCqkkqqQhjlL1jAGYZoLTNc4fNP0PTt\n" +
                        "VcOX0PR4UkYWUekIm/mn6y6z6XnZAiZjJhITUq6eSb3szCQXLpUSjyHAiB4cIIOJDgn4jeDR8nZ4\n" +
                        "y66FskwGpkrVAydXujOrO3i+wtGzK0JNJNZSPfMHxXMIyTUbECPi2kGYhwBdAczfZ3EBK8V3B3ww\n" +
                        "6nhHJmWx+LeyxWqNjoMlSpO64z10/wCw347FLkoqzRbjAvSsFVOqUU5eH7UDIyKYnkbT4dopjxQO\n" +
                        "+JuFs0jDyk9rFlrW6U9sxbGh7cnDyb2QgrFIPDLFcpS8Uk6QjkxIioRVhHskRMmCZutp3UfAVr/U\n" +
                        "XEfdOISLtdglS2CQu0zVNdvmzVOra7mdjvIp9d5Gt9mqYxTza8UgQyYNmwN2xGrYhjEZo8w+HxEz\n" +
                        "Gva7dtF8PlK4aaZvrabSlzMrrWrXF3CQlK1pQqm2iq85nHkxMxFgTiwAox8RHIxUG6lHBEjIJKN0\n" +
                        "DGOPMetY68626RfUrSZ03qfQzra+mdmJ26taguLixQ10SrTiIfQ0/Y4wlVqMfHzkO5BVkyfIs3bh\n" +
                        "+2cOgcOjFQSKHePEBwtLbfvFB25Qdr2vRu5dcx8xBQd+q8VB2RF7V59RuvK1yw1WzIrwU7GrOmqD\n" +
                        "pEj1I3sdYomAp+YAXAtf8DoVffdN4lbpvDYG1tswFfs9enpm1x8Ewjp5jPIItmLSHr1eRjYGkxMC\n" +
                        "mVyo1ioKOFN66eruny6q49YQxLhrIQvGr0hIlKUomn9QcxAoAI/+yqCP8IgHw/tHOb4f/EcxvjMI\n" +
                        "joXhb2DrbV/Rk3m47drx7fr1rctuw8/Tk0EXSlvC1bXfVaNqpW7lVFsqFhlpljEqA6VTZkRdqKvD\n" +
                        "FaJrGCRzX2g4nX+396bdaWCQkH+83tUeysMu0botII9VrTKtIlYuiKHVdA7bsk3Corpp9kqYxSgY\n" +
                        "vwjqOC4HNeNOFa08J9jsM/ZKdaZefnVbCkRvCWCMlpW4FvUVIxpmx3LdJ3W7Igyex51CqIuQZJoP\n" +
                        "kFkFV01Qjb4wahsuL4bJPZTzgx4e+H9rQHtFtNOutS2M0a7T14/G411tElj4+ta6hmKzuSO/ThJa\n" +
                        "v+MPsM6L90UTLOWzZUN+cddeiNuXno06/dllPA972q4LY0UHSrE0ojKUiGePont2xklU0Zg5jRyy\n" +
                        "aR0xVQdKI/6pxIOxbn0eF427Qldcb14xNtbTq0Y2ZBS4hao0epx8HKxzlsaPnrKFZas5TYkpGskl\n" +
                        "28cNql12zZ448KqN3DxFMc3hxA8GFT4hmeho6x3S111tomSVlIpzVVCRk1KPfADKFZvEJlNYriCf\n" +
                        "RyzBvKtHTRN0AOiAkqkoh1yHDmHjl1TrvRa/C9urTNQrWttkVfiG1vr2OcUyIZV/xmpdzM+jZ+nz\n" +
                        "DGLQbNpyNIyaElG6L5JwqwCOcmaim3dSAK7IrP8A3sGz/wDojo//AKuPczCt8FlhktnUfY/EHxGX\n" +
                        "/iMS1Q7VlNV1CzVak0yt1qfOgLNKzTTOkx0ajcrEzaCBWUrMIEcIriqsInTcLt1N4x2gIqO4nbJx\n" +
                        "NFsUgrNWPTsNp9WrGZtixbWPhrStaCTKb4FBdqPV11hanbGSKgRIvXA5jjyAIheE53Z9kNtz7ps/\n" +
                        "B204mb1ft0bHhJ++Waz0FVODhK4/bRMXrqGrlxK5XrkLCtSdqLJBs2Tf+ziqnFZqmyTQ734CNZbV\n" +
                        "1Qz3lXbfQHGrdXyuzfG/SWu3Vlj7QpSoGxx3b2atM3sedRFrDMJ1AF4qPSEGrVF4oDconM4Of6c/\n" +
                        "wW2KA2Dddh8NPEZfOG1xsuWUsewKlD1OlbHoE3aV000ntmj6nfI98xrs1JgkRSUdRZiA7WADFIil\n" +
                        "/g50RpLV1u1fBzLW87ovm77LPzAy76zXZCCi0mIA1Qapxdbrdaj46DrsSQETODM2KAlVdLKrqGE5\n" +
                        "sDdOMYwGMYwGMYwGMYwGMYwGMYwPFx/7uv8A/RV//A2fBrv/AMS/+8N/+2MYGSYxjAYxjAYxjAYx\n" +
                        "jAYxjAYxjAYxjAYxjAYxjA//2Q==\n"
            }
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
                    "INSERT INTO items(fname,lname,item_name,more_detail,lost_place,contact,tel,latitude,longitude,img1,img2,img3,img4,type,report_or_missing,email) VALUES('$fname_2', '$lname_2','$item_name','$more_detail','$lost_place','$contact','$telNumber','$latitude2','$longitude2','$img1','$img2','$img3','$img4','$item_type',2,'$email2')",
                    "UTF-8"
                ).trim()
                val host = "10.48.104.49"
                val path = "/myapi/test5.php"
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
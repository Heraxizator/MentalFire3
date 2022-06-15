package com.myapp.mentalfire3

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.myapp.mentalfire3.databinding.*


class AnchorFragment : Fragment() {

    private var _binding: FragmentAnchorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAnchorBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val anchor = binding.anchor

        anchor.setOnClickListener {
            try {
                val v = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v!!.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    v!!.vibrate(1000)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        val ad = Ad(requireContext())
        ad.loadFullScreenAd("R-M-1708838-16")

    }
}
package com.myapp.mentalfire3


import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.myapp.mentalfire3.databinding.FragmentDisappearBinding

import java.io.*
import kotlin.math.round


class DisappearFragment : Fragment(), View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private var _binding: FragmentDisappearBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var loadview : ImageView? = null

    /*
    private val startActivityIntent = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) {
        if (it != null) {

            //findNavController().navigate(R.id.action_disappearFragment_to_SecondFragment)
            binding.loadimage.setImageURI(it)
        }
        //Toast.makeText(requireContext(), "11111", Toast.LENGTH_SHORT).show()
    }

     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentDisappearBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadview = binding.loadimage

        binding.loadimage.setOnClickListener(this)

        binding.size.setOnSeekBarChangeListener(this)
        binding.opacity.setOnSeekBarChangeListener(this)

        binding.btnclear.setOnClickListener(this)
        binding.btnend.setOnClickListener(this)




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun changeSize(image : ImageView, w : Int, h : Int) {
        val params = image.layoutParams
        params.height = w
        params.width = h
        image.layoutParams = params
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.loadimage -> {
                binding.loadimage.setImageResource(R.drawable.cube)
                changeSize(binding.loadimage, 500, 500)


            }



            R.id.btnclear -> {
                val image = binding.loadimage
                changeSize(image, 500, 500)
                binding.ovalue.text = "100"
                binding.svalue.text = "100"
                binding.opacity.progress = 100
                binding.size.progress = 100
                image.setImageResource(R.drawable.ic_download)
            }

            R.id.btnend -> {
                findNavController().navigate(R.id.action_disappearFragment_to_SecondFragment)
            }

        }
    }


    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        val progress = p0?.progress
        val image = binding.loadimage
        val svalue = binding.svalue
        val ovalue = binding.ovalue
        when (p0?.id) {
            R.id.opacity -> {
                binding.ovalue.text = progress.toString()
                image.alpha = 0.01f * progress!!
            }

            R.id.size -> {
                svalue.text = progress.toString()
                val params = image.layoutParams
                val k = 5.0
                val p = round(k * progress!!).toInt()
                changeSize(image, p, p)

            }
        }
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }


    override fun onDestroy() {
        super.onDestroy()
        val ad = Ad(requireContext())
        ad.loadFullScreenAd("R-M-1708838-10")

    }









}



package com.myapp.mentalfire3

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SeekBar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.myapp.mentalfire3.databinding.FragmentSpinnerBinding


class SpinnerFragment : Fragment(), View.OnClickListener, View.OnKeyListener {

    private var _binding: FragmentSpinnerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSpinnerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnend = binding.btnend
        val btnclear = binding.btnclear
        val seekbar = binding.seekbar
        val value = binding.value




        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                value.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })



        btnend.setOnClickListener(this)
        btnclear.setOnClickListener(this)
        binding.finput.setOnKeyListener(this)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        val einput = binding.einput
        val finput = binding.finput
        val seekbar = binding.seekbar
        val value = binding.value
        val btnclear = binding.value
        when (p0?.id) {
            R.id.btnend -> {
                findNavController().navigate(R.id.action_spinnerFragment_to_SecondFragment)
            }

            R.id.btnclear -> {
                einput.text.clear()
                finput.text.clear()
                seekbar.progress = 0
                value.text = "0"
            }



        }
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        val finput = binding.finput
        if ((p1 == KeyEvent.KEYCODE_ENTER) && (p0?.id == R.id.finput)) {
            binding.einput.clearFocus()
            finput.clearFocus()
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(p0.windowToken, 0)
        }

        if ((p1 == KeyEvent.KEYCODE_DEL) && (p0?.id == R.id.finput)) {
            val text = finput.text
            if (text.isNotEmpty()) {
                try {
                    finput.setText(text.substring(0, text.lastIndex))
                    finput.setSelection(text.length - 1)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }


        }


        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        val ad = Ad(requireContext())
        ad.loadFullScreenAd("R-M-1708838-2")



    }
}
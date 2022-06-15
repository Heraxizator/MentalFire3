package com.myapp.mentalfire3

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
import com.myapp.mentalfire3.databinding.FragmentComparisonBinding

class ComparisonFragment : Fragment(), View.OnClickListener, View.OnKeyListener {

    private var _binding: FragmentComparisonBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentComparisonBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnclear.setOnClickListener(this)
        binding.btnend.setOnClickListener(this)

        binding.futureinput.setOnKeyListener(this)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnend -> {
                findNavController().navigate(R.id.action_comparisonFragment_to_SecondFragment)
            }

            R.id.btnclear -> {

                val problem = binding.pinput
                val past = binding.pastinput
                val present = binding.presentinput
                val future = binding.futureinput

                problem.text.clear()
                past.text.clear()
                present.text.clear()
                future.text.clear()

                problem.clearFocus()
                past.clearFocus()
                present.clearFocus()
                future.clearFocus()
            }


        }
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        if ((p1 == KeyEvent.KEYCODE_ENTER) && (p0?.id == R.id.futureinput)) {
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(p0.windowToken, 0)
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        val ad = Ad(requireContext())
        ad.loadFullScreenAd("R-M-1708838-4")

    }
}
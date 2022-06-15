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
import com.myapp.mentalfire3.databinding.FragmentProblemBinding


class ProblemFragment : Fragment(), View.OnClickListener, View.OnKeyListener {

    private var _binding: FragmentProblemBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProblemBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnclear.setOnClickListener(this)
        binding.btnend.setOnClickListener(this)

        binding.question9.setOnKeyListener(this)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnend -> {
                findNavController().navigate(R.id.action_problemFragment_to_SecondFragment)
            }

            R.id.btnclear -> {

                val q1 = binding.question1
                val q2 = binding.question2
                val q3 = binding.question3
                val q4 = binding.question4
                val q5 = binding.question5
                val q6 = binding.question6
                val q7 = binding.question7
                val q8 = binding.question8
                val q9 = binding.question9

                q1.text.clear()
                q2.text.clear()
                q3.text.clear()
                q4.text.clear()
                q5.text.clear()
                q6.text.clear()
                q7.text.clear()
                q8.text.clear()
                q9.text.clear()

                q1.clearFocus()
                q2.clearFocus()
                q3.clearFocus()
                q4.clearFocus()
                q5.clearFocus()
                q6.clearFocus()
                q7.clearFocus()
                q8.clearFocus()
                q9.clearFocus()
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
        ad.loadFullScreenAd("R-M-1708838-11")

    }


}
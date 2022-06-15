package com.myapp.mentalfire3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.myapp.mentalfire3.databinding.FragmentPolarityBinding


class PolarityFragment : Fragment() {

    private var _binding: FragmentPolarityBinding? = null

    private var n = 0

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPolarityBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numbers = mutableListOf(0)

        val negative = mutableListOf("")
        val positive = mutableListOf("")

        val mylist = ArrayList<Polarity>()

        for (i in numbers.indices) {
            val polarity = Polarity(numbers[i], negative[i], positive[i])
            mylist.add(polarity)
        }

        val list = binding.polaritylist

        list.adapter = PolarityAdapter(requireContext(), mylist)
        list.isStackFromBottom = true


        binding.plus.setOnClickListener {

            for (i in 0 until list.adapter.count) {
                try {
                    val order = list.getChildAt(i)
                    val fedit = order.findViewById<EditText>(R.id.fedit)
                    val sedit = order.findViewById<EditText>(R.id.sedit)
                    negative[i] = fedit.text.toString()
                    positive[i] = sedit.text.toString()
                    mylist[i].negative = negative[i]
                    mylist[i].positive = positive[i]
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            n += 1
            numbers.add(n)
            negative.add("")
            positive.add("")
            val polarity = Polarity(numbers[n], negative[n], positive[n])
            mylist.add(polarity)
            (list.adapter as PolarityAdapter).notifyDataSetChanged()
            /*

            for (i in 0 until list.count) {
                val item = list[i]

            }

            n += 1
            numbers.add(n)
            negative.add("")
            positive.add("")
            val polarity = Polarity(numbers[n], negative[n], positive[n])
            mylist.add(polarity)
            Toast.makeText(requireContext(), ""+negative, Toast.LENGTH_SHORT).show()

            (list.adapter as PolarityAdapter).notifyDataSetChanged()


             */


        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        val ad = Ad(requireContext())
        ad.loadFullScreenAd("R-M-1708838-7")

    }


}
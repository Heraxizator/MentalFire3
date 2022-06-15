package com.myapp.mentalfire3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.myapp.mentalfire3.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = intArrayOf(
            R.drawable.s, R.drawable.n, R.drawable.l, R.drawable.k, R.drawable.j,
            R.drawable.i, R.drawable.y, R.drawable.z, R.drawable.i, R.drawable.v,
            R.drawable.z, R.drawable.x

        )

        val maintexts = arrayOf(
            resources.getString(R.string.main1), resources.getString(R.string.main2), resources.getString(R.string.main3), resources.getString(R.string.main4),
            resources.getString(R.string.main5), resources.getString(R.string.main6), resources.getString(R.string.main7), resources.getString(R.string.main8),
            resources.getString(R.string.main9), resources.getString(R.string.main10), resources.getString(R.string.main11), resources.getString(R.string.main12)
        )

        val subtexts = arrayOf(
            resources.getString(R.string.sub1),  resources.getString(R.string.sub2), resources.getString(R.string.sub3), resources.getString(R.string.sub4),
            resources.getString(R.string.sub5), resources.getString(R.string.sub6), resources.getString(R.string.sub7), resources.getString(R.string.sub8),
            resources.getString(R.string.sub9), resources.getString(R.string.sub10), resources.getString(R.string.sub11), resources.getString(R.string.sub12)
        )


        val list = binding.list

        val techniques = ArrayList<Technique>()
        val sp = SharedPreferences(requireContext())

        for (i in 0 until maintexts.lastIndex + 1) {
            val technique = Technique(images[i], maintexts[i], subtexts[i])
            if ((i == maintexts.lastIndex) && (!sp.getAdPlus())) {

            }
            else {
                techniques.add(technique)
            }


        }


        list.adapter = ListAdapter(requireContext(), techniques)

        list.isClickable = true
        list.setOnItemClickListener { _, _, i, _ ->
            val sp = SharedPreferences(requireContext())
            val n = i + 1
            sp.setNumber(n)
            when (n) {
                1 -> {
                    if (sp.getSpinner()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_spinnerFragment)

                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setSpinner(true)
                    }
                }

                2 -> {
                    if (sp.getDisappear()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_disappearFragment)

                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setDisappear(true)
                    }
                }

                3 -> {
                    if (sp.getComparison()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_comparisonFragment)

                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setComparison(true)
                    }
                }

                4 -> {
                    if (sp.getBook()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_bookFragment)

                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setBook(true)
                    }
                }

                5 -> {
                    if (sp.getPolarity()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_polarityFragment)

                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setPolarity(true)
                    }
                }

                6 -> {
                    if (sp.getFive()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_fiveFragment)

                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setFive(true)
                    }
                }

                7 -> {
                    if (sp.getNothing()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_nothingFragment)

                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setNothing(true)
                    }
                }

                8 -> {
                    if (sp.getProblem()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_problemFragment)
                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setProblem(true)
                    }
                }

                9 -> {
                    if (sp.getAnchor()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_anchorFragment)
                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setAnchor(true)
                    }
                }

                10 -> {
                    if (sp.getTime()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_timeFragment)
                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setTime(true)
                    }
                }

                11 -> {
                    if (sp.getFear()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_fearFragment)
                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setFear(true)
                    }
                }

                12 -> {
                    if (sp.getDecart()) {
                        findNavController().navigate(R.id.action_SecondFragment_to_decartFragment)
                    }

                    else {
                        findNavController().navigate(R.id.action_SecondFragment_to_theoryFragment)
                        sp.setDecart(true)
                    }
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
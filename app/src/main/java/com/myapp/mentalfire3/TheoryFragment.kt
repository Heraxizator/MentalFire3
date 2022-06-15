package com.myapp.mentalfire3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.myapp.mentalfire3.databinding.FragmentTheoryBinding



class TheoryFragment : Fragment() {

    private var _binding: FragmentTheoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTheoryBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val layout = binding.theorylayout
        val block = binding.theoryblock
        val n = SharedPreferences(requireContext()).getNumber()
        when (n) {
            1 -> {
                block.text = resources.getString(R.string.theory1)
            }

            2 -> {
                block.text = resources.getString(R.string.theory2)
            }

            3 -> {
                block.text = resources.getString(R.string.theory3)
            }

            4 -> {
                block.text = resources.getString(R.string.theory4)
            }

            5 -> {
                block.text = resources.getString(R.string.theory5)
            }

            6 -> {
                block.text = resources.getString(R.string.theory6)
            }

            7 -> {
                block.text = resources.getString(R.string.theory7)
            }

            8 -> {
                block.text = resources.getString(R.string.theory8)
            }

            9 -> {
                block.text = resources.getString(R.string.theory9)
            }

            10 -> {
                block.text = resources.getString(R.string.theory10)
            }

            11 -> {
                block.text = resources.getString(R.string.theory11)
            }

            12 -> {
                block.text = resources.getString(R.string.theory12)
            }


        }

        layout.setOnClickListener {



            //Toast.makeText(requireContext(), ""+n, Toast.LENGTH_SHORT).show()
            when (n) {
                1 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_spinnerFragment)
                }

                2 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_disappearFragment)
                }

                3 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_comparisonFragment)

                }

                4 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_bookFragment)
                }

                5 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_polarityFragment)

                }

                6 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_fiveFragment)
                }

                7 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_nothingFragment)

                }

                8 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_problemFragment)
                }

                9 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_anchorFragment)
                }

                10 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_timeFragment)
                }

                11 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_fearFragment)
                }

                12 -> {
                    findNavController().navigate(R.id.action_theoryFragment_to_decartFragment)
                }
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
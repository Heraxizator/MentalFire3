package com.myapp.mentalfire3

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.UnderlineSpan
import android.util.TypedValue
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.myapp.mentalfire3.databinding.FragmentBookBinding


class BookFragment : Fragment(), View.OnClickListener, View.OnKeyListener {

    private var _binding: FragmentBookBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var keyb = false
    private var keyi = false
    private var keynum = false
    private var keybul = false
    private var fontSize = 18f
    private var numeric = false
    private var bulled = false
    private var tab = false
    private var line = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBookBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textarea = binding.textarea
        val bulled = binding.bulled
        val numeric = binding.numeric

        textarea.setOnKeyListener(this)

        binding.increase.setOnClickListener(this)
        binding.decrease.setOnClickListener(this)
        binding.bold.setOnClickListener(this)
        binding.italic.setOnClickListener(this)
        binding.underlined.setOnClickListener(this)
        binding.tab.setOnClickListener(this)
        numeric.setOnClickListener(this)
        bulled.setOnClickListener(this)

    }


    fun normalTypeface(textarea : EditText) {
        textarea.setTypeface(null, Typeface.NORMAL)
    }

    fun boldAndItalic(textarea : EditText) {
        textarea.setTypeface(null, Typeface.BOLD_ITALIC)
    }

    fun changeColor(btn : ImageButton, key : Boolean) {
        if (key == false) {
            btn.background = resources.getDrawable(R.color.light)
        }

        else {
            btn.background = resources.getDrawable(android.R.color.transparent)
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    fun btnClicked(btn : ImageButton) {
        val intcolor = R.color.yellow

        when (btn.id) {
            R.id.bold -> {
                changeColor(btn, keyb)
                keyb = !keyb
            }

            R.id.italic -> {
                changeColor(btn, keyi)
                keyi = !keyi
            }

            R.id.bulled -> {
                changeColor(btn, keybul)

                keybul = !keybul
            }

            R.id.numeric -> {
                changeColor(btn, keynum)

                keynum = !keynum
            }
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        val textarea = binding.textarea
        when (p0?.id) {




            R.id.increase -> {
                fontSize += 1
                textarea.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize)

            }

            R.id.decrease -> {
                fontSize -= 1
                textarea.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize)
            }



            R.id.italic -> {
                if (keyi == false) {
                    textarea.setTypeface(null, Typeface.ITALIC)
                }

                else {
                    normalTypeface(textarea)
                }



                btnClicked(binding.italic)
            }

            R.id.bold -> {
                if (keyb == false) {
                    textarea.setTypeface(null, Typeface.BOLD)
                }

                else {
                    normalTypeface(textarea)
                }

                btnClicked(binding.bold)
            }

            /*
            R.id.underlined -> {
                val mString = textarea.text
                val content = SpannableString(mString)


                if (keyu == false) {
                    content.setSpan(UnderlineSpan(), 0, mString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    textarea.setText(content)
                }
                else {
                    textarea.setText(mString)
                }

                textarea.setSelection(textarea.text.length)
                btnClicked(binding.underlined)


            }

             */

            /*

            R.id.tab -> {
                val space = "    "
                val text = textarea.text

                if (tab == false) {
                    textarea.setText(space + text)
                    textarea.setSelection(textarea.text.length)
                    tab = true
                }


            }

             */

            R.id.numeric -> {
                val text = textarea.text

                keybul = false
                btnClicked(binding.numeric)




            }


            R.id.bulled -> {
                val text = textarea.text
                /*
                if (bulled == false) {

                    val newtext = "●" + text.replace("\n".toRegex(), "\n● ")
                    textarea.setText(newtext)
                    bulled = true
                }

                else {
                    val newtext = text.replace("●".toRegex(), "")
                    textarea.setText(newtext)
                    bulled = false
                }

                 */


                keynum = false
                btnClicked(binding.bulled)




            }

        }
    }



    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        val textarea = binding.textarea
        val text = textarea.text
        if (p1 == KeyEvent.KEYCODE_ENTER) {

            if (keybul == true) {


                val newtext = text.append("\n●")
                textarea.setText(newtext)


            }

            if (keynum == true) {
                val newtext = text.append("\n$line.")
                textarea.setText(newtext)
                line += 1

            }

            if ((keynum == false) && (keybul == false)) {
                textarea.setText(textarea.text.append("\n"))
            }

        }


        if (p1 == KeyEvent.KEYCODE_DEL) {
            try {
                if (textarea.text.isNotEmpty()) {
                    textarea.setText(text.substring(0, text.lastIndex))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }


        }

        try {
            textarea.setSelection(textarea.text.lastIndex + 1)
        }catch (e : java.lang.Exception) {
            e.printStackTrace()
        }

        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        val ad = Ad(requireContext())
        ad.loadFullScreenAd("R-M-1708838-5")

    }


}
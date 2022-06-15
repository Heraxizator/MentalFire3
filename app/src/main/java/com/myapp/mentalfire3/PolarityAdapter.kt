package com.myapp.mentalfire3

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import com.google.android.material.slider.Slider

class PolarityAdapter(context: Context, val mylist : List<Polarity>) : ArrayAdapter<Polarity> (context, R.layout.polarity, mylist) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.polarity, null)

        val fedit = view.findViewById<EditText>(R.id.fedit)
        val sedit = view.findViewById<EditText>(R.id.sedit)

        val item = mylist[position]

        fedit.setText(item.negative)
        sedit.setText(item.positive)


        return view
    }

    override fun add(`object`: Polarity?) {
        super.add(`object`)
    }

    override fun notifyDataSetChanged() {
        super.notifyDataSetChanged()
    }

    override fun getItem(position: Int): Polarity? {
        return super.getItem(position)
    }

    override fun getCount(): Int {
        return super.getCount()
    }

    override fun setNotifyOnChange(notifyOnChange: Boolean) {
        super.setNotifyOnChange(notifyOnChange)

    }






}
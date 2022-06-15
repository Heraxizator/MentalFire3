package com.myapp.mentalfire3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(context: Context, val arrayList: ArrayList<Technique>) : ArrayAdapter<Technique>(context, R.layout.list_item, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_item, null)

        val bimage = view.findViewById<ImageView>(R.id.image)
        val bmaintext = view.findViewById<TextView>(R.id.tmain)
        val bsubtext = view.findViewById<TextView>(R.id.tsub)

        bimage.setImageResource(arrayList[position].image)
        bmaintext.text = arrayList[position].maintext
        bsubtext.text = arrayList[position].subtext

        return view


    }
}
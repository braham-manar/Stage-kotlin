package com.example.stagekotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardViewAdapter : RecyclerView.Adapter<CardViewAdapter.ViewHolder>() {
    private val itemTitle = arrayOf("test1","text2")
    private val itemDesc = arrayOf("test1Desc","text2Desc")
    private val itemImages= intArrayOf(
        R.drawable.img,
        R.drawable.image,
        R.drawable.img_5terre,
        R.drawable.img,
    R.drawable.icon)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_new_recycler, parent, false)
        return ViewHolder(v)
    }



    override fun getItemCount(): Int {
        return itemTitle.size

    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image:ImageView
        var textTitle:TextView
        var textDesc : TextView


        init {
            image = itemView.findViewById(R.id.Iv_Item)
            textTitle= itemView.findViewById(R.id.TV_title)
            textDesc = itemView.findViewById(R.id.TV_Desc)

           /* itemView.setOnClickListener {

            }*/
        }
    }

    override fun onBindViewHolder(holder: CardViewAdapter.ViewHolder, position: Int) {
        holder.textTitle.text = itemTitle[position]
        holder.textDesc.text = itemDesc[position]
        holder.image.setImageResource(itemImages[position])
    }
}
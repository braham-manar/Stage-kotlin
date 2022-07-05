package com.example.stagekotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_new_recycler.view.*
import kotlinx.android.synthetic.main.url_item.view.*

class MyAdapter(val context: Context, val list: List<Hit>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var Id:TextView
        var IV:ImageView
        init {
            Id=itemView.TV_retro
            IV=itemView.Iv_retro
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView=LayoutInflater.from(context).inflate(R.layout.url_item,parent,false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Id.text=list[position].id.toString()
        holder.IV.setImageResource(list[position].downloads)

    }

    override fun getItemCount(): Int {
        return list.size

    }

}



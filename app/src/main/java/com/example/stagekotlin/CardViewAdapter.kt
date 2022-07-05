package com.example.stagekotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CardViewAdapter : RecyclerView.Adapter<CardViewAdapter.ViewHolder>() {
    private val itemTitle = arrayOf("test1","text2")
    private val itemDesc = arrayOf("test1Desc","text2Desc")
    private lateinit var search_V : SearchView
    private lateinit  var mListener : AdapterInteraction

    interface AdapterInteraction {
        fun onItemClick(position: Int)
        fun onFavoritesButtonClicked(i : Int)
        fun onTextViewClicked()

    }

    fun setAdapterInteractionListener (listner:AdapterInteraction){
        mListener= listner
    }
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
        var cardView : CardView
        var Img :ImageView
      //  var TV :TextView


        init {
            image = itemView.findViewById(R.id.Iv_Item)
            textTitle= itemView.findViewById(R.id.TV_title)
            textDesc = itemView.findViewById(R.id.TV_Desc)
            cardView = itemView.findViewById(R.id.card_view)
            Img = itemView.findViewById(R.id.iv_favoris)
           // TV = itemView.findViewById(R.id.card_view)
         //   search_V = itemView.findViewById(R.id.search_View)

           /* itemView.setOnClickListener {}*/

        }
    }

    override fun onBindViewHolder(holder: CardViewAdapter.ViewHolder, position: Int) {
        holder.textTitle.text = itemTitle[position]
        holder.textDesc.text = itemDesc[position]
        holder.image.setImageResource(itemImages[position])
    //    search_V.clearFocus()
      //  search_V.setOnQueryTextListener(new )

        holder.cardView.setOnClickListener{
            mListener.onItemClick(position)

        }
        holder.Img.setOnClickListener{
            mListener.onFavoritesButtonClicked(position)

        }
    }





}
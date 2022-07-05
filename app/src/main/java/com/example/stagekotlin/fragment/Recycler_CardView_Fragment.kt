package com.example.stagekotlin.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stagekotlin.CardViewAdapter
import com.example.stagekotlin.R
import com.example.stagekotlin.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_notify_.*


class Recycler_CardView_Fragment : Fragment() , CardViewAdapter.AdapterInteraction{

    var cardViewAdapter : CardViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notify_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardViewAdapter = CardViewAdapter()
        recycle_view.apply {
            layoutManager = LinearLayoutManager(activity)
            recycle_view.layoutManager=layoutManager
            adapter = cardViewAdapter
            recycle_view.adapter=adapter
        }
        cardViewAdapter?.setAdapterInteractionListener(this)
    }

    override fun onItemClick(position: Int) {
        Log.i("test_adapter_inte", "onItemClick: $position")
    }

    override fun onFavoritesButtonClicked(i: Int) {
        Log.i("test_favorite", "FavoritesButtonClicked: $i")
        Toast.makeText(requireContext(),"show favorite $i",Toast.LENGTH_SHORT).show()
    }


    override fun onTextViewClicked() {
     }


}



package com.example.stagekotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stagekotlin.CardViewAdapter
import com.example.stagekotlin.R
import com.example.stagekotlin.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_notify_.*


class Recycler_CardView_Fragment : Fragment() {


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
        recycle_view.apply {
            layoutManager = LinearLayoutManager(activity)
            recycle_view.layoutManager=layoutManager
            adapter = CardViewAdapter()
            recycle_view.adapter=adapter
        }
    }
}



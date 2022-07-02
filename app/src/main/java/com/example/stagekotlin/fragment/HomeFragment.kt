package com.example.stagekotlin.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.stagekotlin.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fav_btn.setOnClickListener(){
            Log.i("test_click", "fav_btn: clicked ")
            findNavController().navigate(R.id.fav_Fragment)
        }
     notif_btn.setOnClickListener(){
            Log.i("test_click", "fav_btn: clicked ")
            findNavController().navigate(R.id.notify_Fragment)
        }
        down_btn.setOnClickListener(){
            Log.i("test_click", "fav_btn: clicked ")
            findNavController().navigate(R.id.down_Fragment)
        }

    }

}
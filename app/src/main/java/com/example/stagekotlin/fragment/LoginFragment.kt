package com.example.stagekotlin.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.stagekotlin.R
import com.example.stagekotlin.VirtualDataBase
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    lateinit var pairList: MutableList<Pair<String, String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notification()

        showImageViewFromUrl()
        showCircleImageView()
    }

    private fun showImageViewFromUrl() {


        Glide.with(this).load(
            "https://www.auto-moto.com/wp-content/uploads/sites/9/2022/02/01-peugeot-208-750x410.jpg")

            .into(iv_login);

        Log.i("test__manar", "showImageViewFromUrl: " + "test image")
        Log.e("test__manar", "showImageViewFromUrl: " + "test image")

    }
    private fun showCircleImageView(){
        Glide.with(this).load(
            "https://www.auto-moto.com/wp-content/uploads/sites/9/2022/02/01-peugeot-208-750x410.jpg")

            .into(iv_circle_image);
        Log.i("test__manar", "showImageViewFromUrl: " + "test image")
        Log.e("test__manar", "showImageViewFromUrl: " + "test image")
    }


    private fun notification() {
        var v = VirtualDataBase()
        pairList = v.credentialList
        button.setOnClickListener {
            var exist = false
            var message = "not exist"
            pairList.forEach { item ->
                if (item.first.contains(email.text) && item.second.contains(password.text)) {
                    exist = true
                }
            }
            if (exist) {
                message = "exist"
                findNavController().navigate(R.id.homeFragment)
            }
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        }



    }

}
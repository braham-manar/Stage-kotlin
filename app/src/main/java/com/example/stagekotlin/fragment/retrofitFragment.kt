package com.example.stagekotlin.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stagekotlin.*
import com.example.stagekotlin.models.MyData
import com.example.stagekotlin.models.MyDataItem
import kotlinx.android.synthetic.main.fragment_down_.*
import kotlinx.android.synthetic.main.fragment_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val Basicaly_URL="https://pixabay.com/api/"
class retrofitFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMyHit()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retrofit, container, false)
    }
    private fun getMyHit(){
        val retrofitBuilder= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Basicaly_URL)
            .build()
            .create(ApiRetroInterface ::class.java)
        val retrofitData = retrofitBuilder.getUrl("27699428-7b4c096d9304fd0cd226c44b3","tunisie")
        retrofitData.enqueue(object : Callback<MyRetrofit> {
            override fun onResponse(call: Call<MyRetrofit>, response: Response<MyRetrofit>) {
                Log.i("test_retrofit", "onResponse: ")

             //  val responseBody=response.body()!!
                val MystringBuilder=StringBuilder()
              /*for (MyData in responseBody){
                    MystringBuilder.append(MyData.id)
                    MystringBuilder.append("\n")


                }*/



                MystringBuilder.append(response.body()?.total)

                TV_retro.text=MystringBuilder

            }

            override fun onFailure(call: Call<MyRetrofit>, t: Throwable) {
                Log.i("test_retrofit", "onFailure: ")
            }
        })






}}






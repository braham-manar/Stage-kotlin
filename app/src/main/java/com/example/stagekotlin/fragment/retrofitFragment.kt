package com.example.stagekotlin.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stagekotlin.*
import kotlinx.android.synthetic.main.fragment_retrofit.*
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val Basicaly_URL="https://pixabay.com/api/"
lateinit var myAdapter: MyAdapter
lateinit var linearLayoutManager: LinearLayoutManager
class retrofitFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recycler.setHasFixedSize(true)
        linearLayoutManager= LinearLayoutManager(activity)
        recycler.layoutManager= linearLayoutManager
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

             val responseBody=response.body()!!

               myAdapter=MyAdapter(call,responseBody.hits)
                myAdapter.notifyDataSetChanged()
                recycler.adapter=myAdapter
             /* for (MyData in responseBody.hits){
                    MystringBuilder.append(MyData.id)
                    MystringBuilder.append("\n")


                }*/
                // MystringBuilder.append(response.body()?.hits)

                //recycler =MystringBuilder
            }

            override fun onFailure(call: Call<MyRetrofit>, t: Throwable) {
                Log.i("test_retrofit", "onFailure: ")
            }
        })
    }}






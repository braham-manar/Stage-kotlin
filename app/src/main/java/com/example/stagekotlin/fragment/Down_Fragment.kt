package com.example.stagekotlin.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stagekotlin.ApiInterface
import com.example.stagekotlin.models.MyDataItem
import com.example.stagekotlin.R
import kotlinx.android.synthetic.main.fragment_down_.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val Base_URL="https://jsonplaceholder.typicode.com/"
class Down_Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMyData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_down_, container, false)
    }
    private fun getMyData(){
        val retrofitBuilder=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Base_URL)
            .build()
            .create(ApiInterface ::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody=response.body()!!
                val MystringBuilder=StringBuilder()
                for (MyData in responseBody){
                    MystringBuilder.append(MyData.id)
                    MystringBuilder.append("\n")


            }
            txtId.text=MystringBuilder
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("msg","onFailure"+t.message)

            }
        })    }



    }




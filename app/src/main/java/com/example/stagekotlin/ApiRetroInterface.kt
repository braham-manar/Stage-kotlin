package com.example.stagekotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRetroInterface {
    @GET(" ")
    fun getUrl(@Query("key") key : String ,@Query("q") q : String  ): Call<MyRetrofit>
}
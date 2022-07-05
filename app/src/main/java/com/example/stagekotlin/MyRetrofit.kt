package com.example.stagekotlin

import com.google.gson.annotations.SerializedName

data class MyRetrofit(
     val hits: List<Hit>,
      val total: Int,
     val totalHits: Int
)
package com.urbansportsclub.assignment.model

import com.google.gson.annotations.SerializedName


data class ResponsePayload(

  @SerializedName("data") var data: ArrayList<Data> = arrayListOf(),

  )
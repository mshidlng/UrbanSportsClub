package com.urbansportsclub.assignment.model

import com.google.gson.annotations.SerializedName


data class Surplus(

  @SerializedName("surplus_allowed") var surplusAllowed: Boolean? = null,
  @SerializedName("price") var price: Int? = null,
  @SerializedName("formatted_price") var formattedPrice: String? = null,

  )
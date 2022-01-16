package com.urbansportsclub.assignment.model

import com.google.gson.annotations.SerializedName


data class Slugs(

  @SerializedName("nl") var nl: String? = null,
  @SerializedName("en") var en: String? = null,
  @SerializedName("es") var es: String? = null,

  )
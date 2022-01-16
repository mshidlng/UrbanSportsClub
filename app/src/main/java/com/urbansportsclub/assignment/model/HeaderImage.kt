package com.urbansportsclub.assignment.model

import com.google.gson.annotations.SerializedName


data class HeaderImage(

  @SerializedName("desktop") var desktop: String? = null,
  @SerializedName("xxxhdpi") var xxxhdpi: String? = null,
  @SerializedName("xxhdpi") var xxhdpi: String? = null,
  @SerializedName("tablet") var tablet: String? = null,
  @SerializedName("mobile") var mobile: String? = null,
  @SerializedName("xhdpi") var xhdpi: String? = null,
  @SerializedName("hdpi") var hdpi: String? = null,
  @SerializedName("mdpi") var mdpi: String? = null,
  @SerializedName("ldpi") var ldpi: String? = null,
  @SerializedName("thumbnail") var thumbnail: String? = null,
  @SerializedName("orig") var orig: String? = null,

  )
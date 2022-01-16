package com.urbansportsclub.assignment.model

import com.google.gson.annotations.SerializedName


data class Locations(

  @SerializedName("id") var id: Int? = null,
  @SerializedName("street_name") var streetName: String? = null,
  @SerializedName("house_number") var houseNumber: String? = null,
  @SerializedName("addition") var addition: String? = null,
  @SerializedName("city") var city: String? = null,
  @SerializedName("zip_code") var zipCode: String? = null,
  @SerializedName("latitude") var latitude: Double? = null,
  @SerializedName("longitude") var longitude: Double? = null,
  @SerializedName("meeting_notes") var meetingNotes: String? = null,

  )
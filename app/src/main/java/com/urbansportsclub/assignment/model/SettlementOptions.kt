package com.urbansportsclub.assignment.model

import com.google.gson.annotations.SerializedName


data class SettlementOptions(

  @SerializedName("drop_in_enabled") var dropInEnabled: Boolean? = null,
  @SerializedName("reservable_workouts") var reservableWorkouts: Boolean? = null,
  @SerializedName("first_come_first_serve") var firstComeFirstServe: Boolean? = null,

  )
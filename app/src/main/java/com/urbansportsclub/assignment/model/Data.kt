package com.urbansportsclub.assignment.model

import com.google.gson.annotations.SerializedName


data class Data(

  @SerializedName("id") var id: Int? = null,
  @SerializedName("name") var name: String? = null,
  @SerializedName("slug") var slug: String? = null,
  @SerializedName("waitlist_enabled") var waitlistEnabled: Boolean? = null,
  @SerializedName("check_in_radius") var checkInRadius: Int? = null,
  @SerializedName("first_live_at") var firstLiveAt: String? = null,
  @SerializedName("review_count") var reviewCount: Int? = null,
  @SerializedName("review_rating") var reviewRating: Float? = null,
  @SerializedName("header_image") var headerImage: HeaderImage? = HeaderImage(),
  @SerializedName("surplus") var surplus: Surplus? = Surplus(),
  @SerializedName("locations") var locations: ArrayList<Locations> = arrayListOf(),
  @SerializedName("category") var category: Category? = Category(),
  @SerializedName("settlement_options") var settlementOptions: SettlementOptions? = SettlementOptions(),

  )
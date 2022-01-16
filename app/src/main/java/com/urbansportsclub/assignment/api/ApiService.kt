package com.urbansportsclub.assignment.api

import com.urbansportsclub.assignment.model.ResponsePayload
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers(value = ["User-Agent: OneFit/1.19.0"])
    @GET("v2/en-nl/partners/city/UTR")
    suspend fun getGymCenters(): ResponsePayload
}
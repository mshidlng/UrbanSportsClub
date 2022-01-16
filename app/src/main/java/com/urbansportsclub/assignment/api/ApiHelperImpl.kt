package com.urbansportsclub.assignment.api

import com.urbansportsclub.assignment.model.ResponsePayload

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getGymCenters(): ResponsePayload =
        apiService.getGymCenters()
}
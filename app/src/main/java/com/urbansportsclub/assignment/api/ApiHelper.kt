package com.urbansportsclub.assignment.api

import com.urbansportsclub.assignment.model.ResponsePayload


interface ApiHelper {
    suspend fun getGymCenters(): ResponsePayload
}
package com.urbansportsclub.assignment.viewmodel

import android.location.Location
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.urbansportsclub.assignment.adapter.Gym
import com.urbansportsclub.assignment.api.ApiService
import com.urbansportsclub.assignment.api.RetrofitBuilder
import com.urbansportsclub.assignment.utils.Resource
import com.urbansportsclub.assignment.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class GymViewModel : ViewModel() {
    val success = MutableLiveData<Resource<Any>>()
    private var apiService: ApiService = RetrofitBuilder.getRetrofit()

    fun getGymData() {
        success.value = Resource.loading("loading...")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val gymCenters = apiService.getGymCenters()

                val gymsToDisplay = ArrayList<Gym>()
                for (gym in gymCenters.data) {
                    val address =
                        gym.locations[0].streetName.toString()
                            .trim() + ", " + gym.locations[0].city + "\n" + gym.locations[0].zipCode
                    val location = Location("")
                    location.latitude = gym.locations[0].latitude!!
                    location.longitude = gym.locations[0].longitude!!

                    gymsToDisplay.add(Gym(name = gym.name,
                        url = gym.headerImage?.mobile,
                        id = gym.reviewRating,
                        address = address,
                        location = location))
                }
                success.postValue(Resource.success(data = gymsToDisplay))
            } catch (exception: Exception) {
                success.postValue(Resource.error(data = null,
                    message = exception.message ?: "Error Occurred! Please try again"))
            }
        }
    }
}
package com.urbansportsclub.assignment.viewmodel

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.urbansportsclub.assignment.adapter.Gym
import com.urbansportsclub.assignment.api.ApiService
import com.urbansportsclub.assignment.api.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GymViewModel : ViewModel() {
    val success = MutableLiveData<ArrayList<Gym>>()
    private var apiService: ApiService = RetrofitBuilder.getRetrofit()

    fun getGymData() {
        viewModelScope.launch(Dispatchers.IO) {
            val gymCenters = apiService.getGymCenters()

            val gymsToDisplay = ArrayList<Gym>()
            for (gym in gymCenters.data) {
                val address =
                    gym.locations[0].streetName.toString().trim() + ", " + gym.locations[0].city + "\n" + gym.locations[0].zipCode
                val location = Location("")
                location.latitude = gym.locations[0].latitude!!
                location.longitude = gym.locations[0].longitude!!

                gymsToDisplay.add(Gym(name = gym.name,
                    url = gym.headerImage?.mobile,
                    id = gym.reviewRating,
                    address = address,
                    location = location))
            }

            success.postValue(gymsToDisplay)
        }
    }
}
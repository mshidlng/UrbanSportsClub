package com.urbansportsclub.assignment.viewmodel

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LocationViewModel : ViewModel(){

    var locationLiveData = MutableLiveData<Location>()

    fun setLocation(location: Location){
        locationLiveData.postValue(location)
    }


}
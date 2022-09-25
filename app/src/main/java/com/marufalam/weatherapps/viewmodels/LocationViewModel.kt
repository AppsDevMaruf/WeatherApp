package com.marufalam.weatherapps.viewmodels

import android.location.Location
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marufalam.weatherapps.models.CurrentModel
import com.marufalam.weatherapps.models.ForecastModel
import com.marufalam.weatherapps.repos.WeatherRepository
import kotlinx.coroutines.launch

class LocationViewModel:ViewModel() {
    val repository = WeatherRepository()
    var locationLiveData:MutableLiveData<Location> = MutableLiveData()
    var currentModelLD:MutableLiveData<CurrentModel> = MutableLiveData()
    var forecastModelLD:MutableLiveData<ForecastModel> = MutableLiveData()

    fun setNewLocations(location: Location){
        locationLiveData.value = location
    }
    fun fetchData(){
        viewModelScope.launch {
            try {
                currentModelLD.value =repository.fetchCurrentWeatherData(locationLiveData.value!!)
                forecastModelLD.value =repository.fetchForecastWeatherData(locationLiveData.value!!)
            }catch (e:Exception){
                Log.e("LocationViewModel", e.localizedMessage )

            }
        }


    }
}
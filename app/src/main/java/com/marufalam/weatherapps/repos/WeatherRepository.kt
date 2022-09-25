package com.marufalam.weatherapps.repos

import android.location.Location
import com.marufalam.weatherapps.models.CurrentModel
import com.marufalam.weatherapps.models.ForecastModel
import com.marufalam.weatherapps.networks.NetworkService
import com.marufalam.weatherapps.networks.weather_api_key

class WeatherRepository{

    suspend fun fetchCurrentWeatherData(location: Location): CurrentModel{
        val endUrl = "weather?lat=${location.latitude}&lon=${location.longitude}&units=metric&appid=$weather_api_key"
       return NetworkService.weatherServiceApi.getCurrentWeatherData(endUrl)

    }
    suspend fun fetchForecastWeatherData(location: Location): ForecastModel{
        val endUrl = "forecast?lat=${location.latitude}&lon=${location.longitude}&units=metric&appid=$weather_api_key"
        return NetworkService.weatherServiceApi.getForecastWeatherData(endUrl)

    }
}
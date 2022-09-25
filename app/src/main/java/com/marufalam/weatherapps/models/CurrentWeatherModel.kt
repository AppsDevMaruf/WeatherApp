package com.marufalam.weatherapps.models
import com.google.gson.annotations.SerializedName


data class CurrentModel(
    @SerializedName("base")
    val base: String,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("cod")
    val cod: Double,
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("id")
    val id: Double,
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String,
    @SerializedName("rain")
    val rain: Rain,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("timezone")
    val timezone: Double,
    @SerializedName("visibility")
    val visibility: Double,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
) {
    data class Clouds(
        @SerializedName("all")
        val all: Double
    )

    data class Coord(
        @SerializedName("lat")
        val lat: Double,
        @SerializedName("lon")
        val lon: Double
    )

    data class Main(
        @SerializedName("feels_like")
        val feelsLike: Double,
        @SerializedName("grnd_level")
        val grndLevel: Double,
        @SerializedName("humidity")
        val humidity: Double,
        @SerializedName("pressure")
        val pressure: Double,
        @SerializedName("sea_level")
        val seaLevel: Double,
        @SerializedName("temp")
        val temp: Double,
        @SerializedName("temp_max")
        val tempMax: Double,
        @SerializedName("temp_min")
        val tempMin: Double
    )

    data class Rain(
        @SerializedName("1h")
        val h: Double
    )

    data class Sys(
        @SerializedName("country")
        val country: String,
        @SerializedName("sunrise")
        val sunrise: Long,
        @SerializedName("sunset")
        val sunset: Long
    )

    data class Weather(
        @SerializedName("description")
        val description: String,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("id")
        val id: Double,
        @SerializedName("main")
        val main: String
    )

    data class Wind(
        @SerializedName("deg")
        val deg: Double,
        @SerializedName("gust")
        val gust: Double,
        @SerializedName("speed")
        val speed: Double
    )
}
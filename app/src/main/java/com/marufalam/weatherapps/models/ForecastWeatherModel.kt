package com.marufalam.weatherapps.models
import com.google.gson.annotations.SerializedName


data class ForecastModel(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Double,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<ForeCastList>,
    @SerializedName("message")
    val message: Double
) {
    data class City(
        @SerializedName("coord")
        val coord: Coord,
        @SerializedName("country")
        val country: String,
        @SerializedName("id")
        val id: Double,
        @SerializedName("name")
        val name: String,
        @SerializedName("population")
        val population: Double,
        @SerializedName("sunrise")
        val sunrise: Long,
        @SerializedName("sunset")
        val sunset: Long,
        @SerializedName("timezone")
        val timezone: Double
    ) {
        data class Coord(
            @SerializedName("lat")
            val lat: Double,
            @SerializedName("lon")
            val lon: Double
        )
    }

    data class ForeCastList(
        @SerializedName("clouds")
        val clouds: Clouds,
        @SerializedName("dt")
        val dt: Long,
        @SerializedName("dt_txt")
        val dtTxt: String,
        @SerializedName("main")
        val main: Main,
        @SerializedName("pop")
        val pop: Double,
        @SerializedName("rain")
        val rain: Rain,
        @SerializedName("sys")
        val sys: Sys,
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
            @SerializedName("temp_kf")
            val tempKf: Double,
            @SerializedName("temp_max")
            val tempMax: Double,
            @SerializedName("temp_min")
            val tempMin: Double
        )

        data class Rain(
            @SerializedName("3h")
            val h: Double
        )

        data class Sys(
            @SerializedName("pod")
            val pod: String
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
}
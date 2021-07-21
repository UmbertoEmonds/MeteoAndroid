package fr.projet2.monprojetmeteo.model

import java.util.*

data class Weathers (val message: String, val cod: String, val count: Int, val list: ArrayList<Weather>)

data class Weather (val id: Int, val name: String, val coord: Coord, val main: MainWeather, val dt: Int, val wind: WindWeather, val clouds: CloudWeather, val weather: ArrayList<ResumeWeather>)

data class Coord (val lat: Double, val long: Double)

data class MainWeather (val temp: Double, val feels_like: Double, val temp_min: Double, val temp_max: Double, val pressure: Int, val humidity: Int)

data class WindWeather (val speed: Double, val deg: Int)

data class CloudWeather(val all: Int)

data class ResumeWeather (val id: Int, val main: String, val description: String, val icon: String)
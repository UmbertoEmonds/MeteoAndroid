package fr.projet2.monprojetmeteo.repository

import fr.projet2.monprojetmeteo.model.Weathers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @Headers("x-rapidapi-key: 22fae28da1msh662b3f83df986b0p1b2a6cjsn061536c6a929",
        "x-rapidapi-host: community-open-weather-map.p.rapidapi.com")

    @GET("/find")
    fun getMeteoFromCity(@Query("q") city: String) : Call<Weathers>

}
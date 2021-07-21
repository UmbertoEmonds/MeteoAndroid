package fr.projet2.monprojetmeteo.repository

import fr.projet2.monprojetmeteo.model.Weathers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MeteoService {

    @GET("/{city}")
    fun getMeteoFromCity(@Path("city") id: String) : Call<Weathers>

}
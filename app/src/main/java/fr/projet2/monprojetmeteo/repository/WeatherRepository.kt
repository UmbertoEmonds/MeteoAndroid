package fr.projet2.monprojetmeteo.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import fr.projet2.monprojetmeteo.model.Weathers
import fr.projet2.monprojetmeteo.util.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

    private var weathers = MutableLiveData<Weathers>()
    private val service: WeatherService = RetrofitBuilder.retrofit.create(WeatherService::class.java)

    fun getMeteoFromCity(city: String): MutableLiveData<Weathers>{
        service.getMeteoFromCity(city).enqueue(object : Callback<Weathers> {
            override fun onResponse(call: Call<Weathers>, response: Response<Weathers>) {
                response.body()?.let{
                    weathers.value = response.body()
                }
            }

            override fun onFailure(call: Call<Weathers>, t: Throwable) {
                Log.v("AZERTY", t.message.toString())
            }

        })
        return weathers
    }

}
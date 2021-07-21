package fr.projet2.monprojetmeteo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.projet2.monprojetmeteo.model.Weathers
import fr.projet2.monprojetmeteo.repository.WeatherRepository

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    fun getWeatherFromCity(city: String) : MutableLiveData<Weathers> {
        return weatherRepository.getMeteoFromCity(city)
    }

}
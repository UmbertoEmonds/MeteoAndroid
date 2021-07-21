package fr.projet2.monprojetmeteo.util.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.projet2.monprojetmeteo.repository.WeatherRepository
import fr.projet2.monprojetmeteo.viewmodel.WeatherViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass == WeatherViewModel::class.java){
            return WeatherViewModel(WeatherRepository()) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}
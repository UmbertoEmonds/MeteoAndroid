package fr.projet2.monprojetmeteo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import fr.projet2.monprojetmeteo.R
import fr.projet2.monprojetmeteo.model.Weathers
import fr.projet2.monprojetmeteo.util.factory.ViewModelFactory
import fr.projet2.monprojetmeteo.util.injection.Injection
import fr.projet2.monprojetmeteo.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mWeatherVM: WeatherViewModel
    private lateinit var mCityTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCityTV = findViewById(R.id.mCityTV)

        configureViewModels()

        mWeatherVM.getWeatherFromCity("tourcoing").observe(this, {
            updateUI(it)
        })
    }

    fun configureViewModels(){
        val viewModelFactory: ViewModelFactory = Injection.provideViewModelFactory()
        mWeatherVM = ViewModelProvider(this, viewModelFactory).get(WeatherViewModel::class.java)
    }

    fun updateUI(weathers: Weathers){
        mCityTV.text = weathers.list[0].name
    }

}
package fr.projet2.monprojetmeteo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import fr.projet2.monprojetmeteo.R
import fr.projet2.monprojetmeteo.model.Weathers
import fr.projet2.monprojetmeteo.util.factory.ViewModelFactory
import fr.projet2.monprojetmeteo.util.injection.Injection
import fr.projet2.monprojetmeteo.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mWeatherVM: WeatherViewModel
    private lateinit var mCityTV: TextView
    private lateinit var mCityET: EditText
    private lateinit var mDescriptionTV: TextView
    private lateinit var mIconIV: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCityTV = findViewById(R.id.mCityTV)
        mCityET = findViewById(R.id.saisirET)
        mDescriptionTV = findViewById(R.id.mDescriptionTV)
        mIconIV = findViewById(R.id.iconIV)

        configureViewModels()
    }

    fun configureViewModels(){
        val viewModelFactory: ViewModelFactory = Injection.provideViewModelFactory()
        mWeatherVM = ViewModelProvider(this, viewModelFactory).get(WeatherViewModel::class.java)
    }

    fun updateUI(weathers: Weathers){

        val iconUrl = "https://openweathermap.org/img/w/${weathers.list[0].weather[0].icon}.png"

        Glide.with(applicationContext)
            .load(iconUrl)
            .into(mIconIV)

        mCityTV.text = weathers.list[0].name
        mDescriptionTV.text = "${weathers.list[0].weather[0].main} - ${weathers.list[0].weather[0].description}"
    }

    fun getMeteoFromCity(v: View){
        mWeatherVM.getWeatherFromCity(mCityET.text.toString()).observe(this, {
            updateUI(it)
        })
    }
}
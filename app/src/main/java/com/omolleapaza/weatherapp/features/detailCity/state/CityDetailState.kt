package com.omolleapaza.weatherapp.features.detailCity.state

import com.omolleapaza.weatherapp.model.LocationUI
import com.omolleapaza.weatherapp.model.WeatherUI


data class CityDetailState(
    val currentCity: LocationUI? = null,
    val currentWeather: WeatherUI? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

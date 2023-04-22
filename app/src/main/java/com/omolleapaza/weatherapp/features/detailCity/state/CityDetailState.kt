package com.omolleapaza.weatherapp.features.detailCity.state

import com.omolleapaza.weatherapp.model.WeatherUI


data class CityDetailState(
    val currentCity: WeatherUI? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

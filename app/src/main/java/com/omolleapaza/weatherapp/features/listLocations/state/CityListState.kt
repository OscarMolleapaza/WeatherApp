package com.omolleapaza.weatherapp.features.listLocations.state

import com.omolleapaza.weatherapp.model.LocationUI
import com.omolleapaza.weatherapp.model.WeatherUI


data class CityListState(
    val locationList: List<LocationUI> = emptyList(),
    val weatherData: WeatherUI? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

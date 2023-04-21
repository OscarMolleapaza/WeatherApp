package com.omolleapaza.weatherapp.features.listLocations.state

import com.omolleapaza.weatherapp.model.LocationUI


data class CityListState(
    val locationList: List<LocationUI> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

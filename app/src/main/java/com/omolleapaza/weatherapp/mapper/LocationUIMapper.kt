package com.omolleapaza.weatherapp.mapper

import com.omolleapaza.domain.entities.LocationModel
import com.omolleapaza.domain.entities.WeatherModel
import com.omolleapaza.weatherapp.model.LocationUI
import com.omolleapaza.weatherapp.model.WeatherUI


interface LocationUIMapper {

    fun maplocationDomainToUI(locationModel: LocationModel): LocationUI


    fun mapWeatherDomainToUI(weatherModel: WeatherModel): WeatherUI
}

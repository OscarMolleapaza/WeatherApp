package com.omolleapaza.weatherapp.mapper

import com.omolleapaza.domain.entities.LocationModel
import com.omolleapaza.weatherapp.model.LocationUI


interface LocationUIMapper {

    fun maplocationDomainToUI(locationModel: LocationModel): LocationUI
}

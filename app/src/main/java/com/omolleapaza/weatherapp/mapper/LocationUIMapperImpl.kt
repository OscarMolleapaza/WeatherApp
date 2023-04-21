package com.omolleapaza.weatherapp.mapper

import com.omolleapaza.domain.entities.LocationModel
import com.omolleapaza.weatherapp.model.LocationUI
import javax.inject.Inject


class LocationUIMapperImpl @Inject constructor() : LocationUIMapper{
    override fun maplocationDomainToUI(locationModel: LocationModel): LocationUI {
        return LocationUI(
            locationName = locationModel.locationName,
            country = locationModel.country,
            city = locationModel.city,
            urlImg = locationModel.urlImg,
            urlFlag = locationModel.urlFlag,
            rating = locationModel.rating,
            latitude = locationModel.latitude,
            longitude = locationModel.longitude,
            desc = locationModel.desc,
            id = locationModel.id
        )
    }

}

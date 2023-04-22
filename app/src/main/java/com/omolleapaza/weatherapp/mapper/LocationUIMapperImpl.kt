package com.omolleapaza.weatherapp.mapper

import com.omolleapaza.domain.entities.*
import com.omolleapaza.weatherapp.model.Clouds
import com.omolleapaza.weatherapp.model.LocationUI
import com.omolleapaza.weatherapp.model.WeatherUI
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

    override fun mapWeatherDomainToUI(weatherModel: WeatherModel): WeatherUI {
        return WeatherUI(
            coordinates = com.omolleapaza.weatherapp.model.Coordinates(
                longitude = weatherModel.coordinates.longitude,
                latitude = weatherModel.coordinates.latitude
            ),
            weather = weatherModel.weather.map {
                com.omolleapaza.weatherapp.model.Weather(
                    id = it.id,
                    main = it.main,
                    description = it.description,
                    icon = it.icon
                )
            },
            base = weatherModel.base,
            main = com.omolleapaza.weatherapp.model.Main(
                temp = weatherModel.main.temp,
                feels_like = weatherModel.main.feels_like,
                temp_min = weatherModel.main.temp_min,
                temp_max = weatherModel.main.temp_max,
                pressure = weatherModel.main.pressure,
                humidity = weatherModel.main.humidity,
                sea_level = weatherModel.main.sea_level,
                grnd_level = weatherModel.main.grnd_level
            ),
            visibility = weatherModel.visibility,
            wind = com.omolleapaza.weatherapp.model.Wind(
                speed = weatherModel.wind.speed,
                deg = weatherModel.wind.deg,
                gust = weatherModel.wind.gust
            ),
            clouds = Clouds(
                all = weatherModel.clouds.all
            ),
            dt = weatherModel.dt,
            sys = com.omolleapaza.weatherapp.model.Sys(
                type = weatherModel.sys.type,
                id = weatherModel.sys.id,
                country = weatherModel.sys.country,
                sunrise = weatherModel.sys.sunrise,
                sunset = weatherModel.sys.sunset
            ),
            timezone = weatherModel.timezone,
            id = weatherModel.id,
            name = weatherModel.name,
            cod = weatherModel.cod
        )
    }

}

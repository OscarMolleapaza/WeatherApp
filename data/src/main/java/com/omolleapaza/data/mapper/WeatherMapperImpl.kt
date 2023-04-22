package com.omolleapaza.data.mapper

import com.omolleapaza.data.api.response.WeatherResponse
import com.omolleapaza.data.localdatabase.entity.LocationEntity
import com.omolleapaza.domain.entities.*
import javax.inject.Inject


class WeatherMapperImpl @Inject constructor() : WeatherMapper {
    override suspend fun mapWeatherResponseToModel(requests: WeatherResponse): WeatherModel {
        return WeatherModel(
            coordinates = Coordinates(
                longitude = requests.coordinates.longitude,
                latitude = requests.coordinates.latitude
            ),
            weather = requests.weather.map {
                Weather(
                    id = it.id,
                    main = it.main,
                    description = it.description,
                    icon = it.icon
                )
            },
            base = requests.base,
            main = Main(
                temp = requests.main.temp,
                feels_like = requests.main.feels_like,
                temp_min = requests.main.temp_min,
                temp_max = requests.main.temp_max,
                pressure = requests.main.pressure,
                humidity = requests.main.humidity,
                sea_level = requests.main.sea_level,
                grnd_level = requests.main.grnd_level
            ),
            visibility = requests.visibility,
            wind = Wind(
                speed = requests.wind.speed,
                deg = requests.wind.deg,
                gust = requests.wind.gust
            ),
            clouds = Clouds(
                all = requests.clouds.all
            ),
            dt = requests.dt,
            sys = Sys(
                type = requests.sys.type,
                id = requests.sys.id,
                country = requests.sys.country,
                sunrise = requests.sys.sunrise,
                sunset = requests.sys.sunset
            ),
            timezone = requests.timezone,
            id = requests.id,
            name = requests.name,
            cod = requests.cod
        )
    }


    override suspend fun mapLocationModelToEntity(requests: LocationModel): LocationEntity {
        return LocationEntity(
            locationName = requests.locationName,
            country = requests.country,
            city = requests.city,
            urlImg = requests.urlImg,
            urlFlag = requests.urlFlag,
            rating = requests.rating,
            latitude = requests.latitude,
            longitude = requests.longitude,
            desc = requests.desc,
            id = requests.id
        )
    }

    override suspend fun mapLocationEntityToModel(requests: LocationEntity): LocationModel {
        return LocationModel(
            locationName = requests.locationName,
            country = requests.country,
            city = requests.city,
            urlImg = requests.urlImg,
            urlFlag = requests.urlFlag,
            rating = requests.rating,
            latitude = requests.latitude,
            longitude = requests.longitude,
            desc = requests.desc,
            id = requests.id
        )
    }

    override suspend fun mapLocationModelToEntityList(requests: List<LocationModel>): List<LocationEntity> {
        return requests.map {
            mapLocationModelToEntity(it)
        }
    }

    override suspend fun mapLocationEntityToModelList(requests: List<LocationEntity>): List<LocationModel> {
        return requests.map {
            mapLocationEntityToModel(it)
        }
    }


}
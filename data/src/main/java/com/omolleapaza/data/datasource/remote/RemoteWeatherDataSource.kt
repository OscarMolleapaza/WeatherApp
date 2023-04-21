package com.omolleapaza.data.datasource.remote

import com.omolleapaza.data.api.response.WeatherResponse
import com.omolleapaza.core.Result


interface RemoteWeatherDataSource {

    suspend fun getWeather(latitude: Double, longitude: Double) : Result<WeatherResponse>

}
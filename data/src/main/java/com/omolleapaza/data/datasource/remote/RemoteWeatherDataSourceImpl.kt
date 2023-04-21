package com.omolleapaza.data.datasource.remote

import com.omolleapaza.data.api.ApiClient
import com.omolleapaza.data.api.response.WeatherResponse
import com.omolleapaza.data.utils.safeApiCall
import com.omolleapaza.core.Result
import javax.inject.Inject

class RemoteWeatherDataSourceImpl @Inject constructor(
    private val apiClient: ApiClient
) : RemoteWeatherDataSource {
    override suspend fun getWeather(latitude: Double, longitude: Double): Result<WeatherResponse> {
        return safeApiCall { apiClient.getWeather(latitude = latitude,longitude = longitude) }
    }


}
package com.omolleapaza.data.api

import com.omolleapaza.data.api.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiClient {

    @POST("weather")
    suspend fun getWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") appid: String = "d08d97f1ee9f3d0228a4eb04444199a6"
    ): Response<WeatherResponse>
}

package com.omolleapaza.domain.usecase

import com.omolleapaza.core.Result
import com.omolleapaza.domain.entities.WeatherModel
import com.omolleapaza.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ProdGetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
): GetWeatherUseCase{
    override fun invoke(lat: Double, lon: Double): Flow<Result<WeatherModel>> {
        return repository.getWeather(latitude = lat, longitude = lon)
    }


}
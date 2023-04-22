package com.omolleapaza.domain.usecase

import com.omolleapaza.core.Result
import com.omolleapaza.domain.entities.WeatherModel
import kotlinx.coroutines.flow.Flow


interface GetWeatherUseCase {
    operator fun invoke(lat:Double, lon:Double): Flow<Result<WeatherModel>>
}
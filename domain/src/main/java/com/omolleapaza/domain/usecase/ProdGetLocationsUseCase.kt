package com.omolleapaza.domain.usecase

import com.omolleapaza.core.Result
import com.omolleapaza.domain.entities.LocationModel
import com.omolleapaza.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ProdGetLocationsUseCase @Inject constructor(
    private val repository: WeatherRepository
): GetLocationsUseCase{
    override fun invoke(): Flow<Result<List<LocationModel>>> {
        return repository.getLocations()
    }

}
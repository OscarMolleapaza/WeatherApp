package com.omolleapaza.domain.usecase

import com.omolleapaza.domain.entities.LocationModel
import com.omolleapaza.domain.repository.WeatherRepository
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class ProdInsertLocationUseCase @Inject constructor(
    private val repository: WeatherRepository
): InsertLocationUseCase{
    override fun invoke(locationModel: LocationModel) {
        runBlocking {
            repository.insertLocation(locationModel)
        }
    }


}
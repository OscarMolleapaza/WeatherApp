package com.omolleapaza.domain.usecase

import com.omolleapaza.core.Result
import com.omolleapaza.domain.entities.LocationModel
import kotlinx.coroutines.flow.Flow


interface GetLocationsUseCase {
    operator fun invoke(): Flow<Result<List<LocationModel>>>
}
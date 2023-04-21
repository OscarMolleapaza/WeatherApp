package com.omolleapaza.domain.usecase

import com.omolleapaza.domain.entities.LocationModel


interface InsertLocationUseCase {
    operator fun invoke(locationModel: LocationModel)
}
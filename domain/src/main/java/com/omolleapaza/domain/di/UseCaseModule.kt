package com.omolleapaza.domain.di

import com.omolleapaza.domain.usecase.GetLocationsUseCase
import com.omolleapaza.domain.usecase.InsertLocationUseCase
import com.omolleapaza.domain.usecase.ProdGetLocationsUseCase
import com.omolleapaza.domain.usecase.ProdInsertLocationUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetLocationListUseCase(
        prodGetLocationsUseCase: ProdGetLocationsUseCase,
    ): GetLocationsUseCase

    @Binds
    abstract fun bindInsertLocationUseCase(
        prodInsertLocationUseCase: ProdInsertLocationUseCase,
    ): InsertLocationUseCase
}

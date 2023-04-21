package com.omolleapaza.data.di

import com.omolleapaza.data.datasource.local.LocalWeatherDataSource
import com.omolleapaza.data.datasource.local.LocalWeatherDataSourceImpl
import com.omolleapaza.data.datasource.remote.RemoteWeatherDataSource
import com.omolleapaza.data.datasource.remote.RemoteWeatherDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindRemoteWeatherDataSource(remoteWeatherDataSourceImpl: RemoteWeatherDataSourceImpl): RemoteWeatherDataSource

    @Binds
    abstract fun bindLocalWeatherDataSource(localWeatherDataSourceImpl: LocalWeatherDataSourceImpl): LocalWeatherDataSource
}

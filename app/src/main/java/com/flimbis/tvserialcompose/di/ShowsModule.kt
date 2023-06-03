package com.flimbis.tvserialcompose.di

import com.flimbis.tvserialcompose.data.ShowsDataSource
import com.flimbis.tvserialcompose.data.ShowsDataSourceImpl
import com.flimbis.tvserialcompose.data.repo.ShowsRepository
import com.flimbis.tvserialcompose.data.repo.ShowsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ShowsModule {

    @Binds
    abstract fun bindShowsDatasource(showsDataSource: ShowsDataSourceImpl) : ShowsDataSource

    @Binds
    abstract fun bindShowsRepository(showsRepository: ShowsRepositoryImpl) : ShowsRepository
}
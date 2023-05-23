package com.madiyar.events.presentation.di

import com.madiyar.data.apiservice.ApiService
import com.madiyar.data.repository.MovieRepositoryImpl
import com.madiyar.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(apiService: ApiService): MovieRepository {
        return MovieRepositoryImpl(apiService)
    }

}
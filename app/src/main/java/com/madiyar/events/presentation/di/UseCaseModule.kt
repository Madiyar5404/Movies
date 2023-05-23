package com.madiyar.events.presentation.di

import com.madiyar.domain.repository.MovieRepository
import com.madiyar.domain.usecase.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesUseCase(countryRepository: MovieRepository):GetMovies{
        return GetMovies((countryRepository))
    }
}
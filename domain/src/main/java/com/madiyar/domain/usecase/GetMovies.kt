package com.madiyar.domain.usecase

import com.madiyar.domain.repository.MovieRepository

class GetMovies (private val moviesRepository: MovieRepository) {
    suspend operator fun invoke() = moviesRepository.getAllMovies()
}
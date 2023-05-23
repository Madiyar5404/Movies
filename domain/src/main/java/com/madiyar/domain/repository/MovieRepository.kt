package com.madiyar.domain.repository

import com.madiyar.domain.models.MovieListResponse

interface MovieRepository {
    suspend fun getAllMovies(): MovieListResponse
}

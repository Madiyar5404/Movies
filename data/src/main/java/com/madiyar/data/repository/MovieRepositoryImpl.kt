package com.madiyar.data.repository

import com.madiyar.data.apiservice.ApiService
import com.madiyar.domain.models.MovieListResponse
import com.madiyar.domain.repository.MovieRepository

class MovieRepositoryImpl (private val apiService: ApiService):MovieRepository {

    override suspend fun getAllMovies(): MovieListResponse {
        return apiService.getAllMovies()
    }

}
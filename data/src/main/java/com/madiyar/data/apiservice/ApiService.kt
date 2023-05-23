package com.madiyar.data.apiservice

import com.madiyar.domain.models.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getAllMovies():MovieListResponse
}

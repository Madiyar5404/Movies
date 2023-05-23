package com.madiyar.events.presentation.fragment.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madiyar.domain.models.MovieListResponse
import com.madiyar.domain.usecase.GetMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val getMoviesUseCase: GetMovies) :
    ViewModel() {
    private var _moviesLiveData = MutableLiveData<MovieListResponse?>()
        get() = _moviesLiveData

    private var _status = MutableLiveData<Boolean>()
        get() = _status

    fun getCountries() {
        viewModelScope.launch {
            kotlin.runCatching { _moviesLiveData.postValue(getMoviesUseCase()) }
                .onSuccess {
                    _status.postValue(true)
                }.onFailure {
                    _status.postValue(false)
                }

        }
    }
    }
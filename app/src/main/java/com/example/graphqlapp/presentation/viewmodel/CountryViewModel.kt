package com.example.graphqlapp.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlapp.domain.model.DetailedCountry
import com.example.graphqlapp.domain.model.SimpleCountry
import com.example.graphqlapp.domain.usecases.GetCountriesUseCase
import com.example.graphqlapp.domain.usecases.GetCountryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CountryViewModel(
    private val getCountryUseCase: GetCountryUseCase,
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CountryState())

    val state: StateFlow<CountryState>
        get() = _state

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            _state.update {
                it.copy(
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }
    }


    data class CountryState(
        val countries: List<SimpleCountry> = emptyList(),
        val isLoading: Boolean = false,
        val countryDetail: DetailedCountry? = null
    )
}
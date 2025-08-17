package com.example.graphqlapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.graphqlapp.domain.usecases.GetCountriesUseCase
import com.example.graphqlapp.domain.usecases.GetCountryUseCase

class CountryViewModel(
    private val getCountryUseCase: GetCountryUseCase,
    private val getCountriesUse: GetCountriesUseCase
) : ViewModel() {

}
package com.example.graphqlapp.domain.usecases

import com.example.graphqlapp.data.ApolloCountryClient
import com.example.graphqlapp.domain.CountryClient
import com.example.graphqlapp.domain.model.DetailedCountry

class GetCountryUseCase (private val countryClient: CountryClient) {
    suspend fun getCountry(code : String) : DetailedCountry? {
        return countryClient.getCountry(code)
    }
}
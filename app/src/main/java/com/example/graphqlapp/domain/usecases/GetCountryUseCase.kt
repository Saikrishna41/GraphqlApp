package com.example.graphqlapp.domain.usecases

import com.example.graphqlapp.data.ApolloCountryClient
import com.example.graphqlapp.domain.model.DetailedCountry

class GetCountryUseCase (private val countryClient: ApolloCountryClient) {
    suspend fun getCountry(code : String) : DetailedCountry? {
        return countryClient.getCountry(code)
    }
}
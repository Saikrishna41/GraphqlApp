package com.example.graphqlapp.domain.usecases

import com.apollographql.apollo.ApolloClient
import com.example.graphqlapp.data.ApolloCountryClient
import com.example.graphqlapp.domain.CountryClient
import com.example.graphqlapp.domain.model.SimpleCountry

class GetCountriesUseCase (private val countryClient: CountryClient) {

    suspend fun execute() : List<SimpleCountry> {
        return countryClient.getCountries()
    }
}
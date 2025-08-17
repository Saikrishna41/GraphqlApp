package com.example.graphqlapp.data

import com.apollographql.apollo.ApolloClient
import com.example.graphqlapp.CountriesQuery
import com.example.graphqlapp.CountryQuery
import com.example.graphqlapp.domain.CountryClient
import com.example.graphqlapp.domain.model.DetailedCountry
import com.example.graphqlapp.domain.model.SimpleCountry

class ApolloCountryClient(private val apolloClient: ApolloClient) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient.query(CountriesQuery())
            .execute().data?.countries?.map {
                it.toSimpleCountry()
            } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient.query(CountryQuery(code))
            .execute().data?.country?.toDetailedCountry()
    }
}
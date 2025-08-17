package com.example.graphqlapp.domain

import com.example.graphqlapp.domain.model.DetailedCountry
import com.example.graphqlapp.domain.model.SimpleCountry

interface CountryClient {
    suspend fun getCountries() : List<SimpleCountry>
    suspend fun getCountry(code : String) : DetailedCountry?
}
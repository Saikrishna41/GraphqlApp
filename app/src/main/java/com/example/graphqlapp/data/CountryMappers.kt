package com.example.graphqlapp.data

import com.example.graphqlapp.CountriesQuery
import com.example.graphqlapp.CountryQuery
import com.example.graphqlapp.domain.model.DetailedCountry
import com.example.graphqlapp.domain.model.SimpleCountry


fun CountryQuery.Country.toDetailedCountry() : DetailedCountry {
    return DetailedCountry(
        name = name ?: "",
        capital = capital ?: "",
        emoji = emoji ?: "",
        currency = currency ?: "",
        languages = languages?.mapNotNull { it.name } ?: emptyList(),
    )
}


fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        name = name ?: "",
        capital = capital ?: "",
        emoji = emoji ?: "",
        currency = currency ?: "",
    )
}
package com.example.graphqlapp.presentation.di

import com.apollographql.apollo.ApolloClient
import com.example.graphqlapp.data.ApolloCountryClient
import com.example.graphqlapp.domain.usecases.GetCountriesUseCase
import com.example.graphqlapp.domain.usecases.GetCountryUseCase
import com.example.graphqlapp.presentation.viewmodel.CountryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ApolloClient> {
        ApolloClient.Builder().serverUrl(
                "https://countries.trevorblades.com/graphql").build()
    }
    single<GetCountryUseCase> {
        GetCountryUseCase(get())
    }
    single<GetCountriesUseCase> {
        GetCountriesUseCase(get())
    }
    viewModel {
        CountryViewModel(get(),get())
    }
}
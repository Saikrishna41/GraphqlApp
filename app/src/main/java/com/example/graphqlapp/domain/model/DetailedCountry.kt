package com.example.graphqlapp.domain.model

data class DetailedCountry(
    val name: String,
    val emoji: String,
    val capital: String,
    val currency: String,
    val languages: List<String>
)

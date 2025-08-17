package com.example.graphqlapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.graphqlapp.domain.model.SimpleCountry
import com.example.graphqlapp.presentation.viewmodel.CountryViewModel
import com.example.graphqlapp.ui.theme.GraphqlAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val countryViewModel: CountryViewModel by viewModel()
            val state by countryViewModel.state.collectAsState()

            GraphqlAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountriesScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        countries = state.countries
                    )
                }
            }
        }
    }
}

@Composable
fun CountriesScreen(
    modifier: Modifier = Modifier,
    countries: List<SimpleCountry>
) {
    LazyColumn(modifier = modifier) {
        items(countries) { country ->
            Text(text = country.name)
        }
    }
}
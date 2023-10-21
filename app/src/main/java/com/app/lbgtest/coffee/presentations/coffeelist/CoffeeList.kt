package com.app.lbgtest.coffee.presentations.coffeelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.lbgtest.coffee.presentations.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeListScreen(
    viewModel: CoffeeListViewModel,
    navController: NavController,
) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                AppBar(title = "Coffee list")
            },
        ) {
            it
            val coffeeListState = viewModel.viewState.value

            if (coffeeListState.isLoading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            if (coffeeListState.error.isNotBlank()) {

                Text(
                    text = coffeeListState.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }

            LazyColumn(modifier = Modifier.padding(it)) {
                items(coffeeListState.coffees ?: listOf()) { coffee ->
                    CoffeeItem(
                        coffee = coffee,
                        coffeeId = coffee.id,
                        navigationController = navController
                    )
                }
            }
        }
    }


}


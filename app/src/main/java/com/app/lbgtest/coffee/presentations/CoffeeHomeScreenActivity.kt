package com.app.lbgtest.coffee.presentations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.lbgtest.coffee.presentations.coffeedetails.CoffeeDetailsScreen
import com.app.lbgtest.coffee.presentations.coffeelist.CoffeeListScreen
import com.app.lbgtest.coffee.presentations.coffeelist.CoffeeListViewModel
import com.app.lbgtest.coffee.ui.theme.CoffeeAppLBGTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoffeeHomeScreenActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeAppLBGTheme {
                // A surface container using the 'background' color from the theme
                CoffeeMainScreen()
            }
        }
    }
}

@Composable
fun CoffeeMainScreen(
    modifier: Modifier = Modifier
) {

    val coffeeListViewModel: CoffeeListViewModel = hiltViewModel()
    val coffees = coffeeListViewModel.viewState.value.coffees
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.CoffeeList.route) {

        composable(route = Screens.CoffeeList.route) {
            CoffeeListScreen(
                viewModel = coffeeListViewModel,
                navController = navController,
            )
        }

        composable(route = "${Screens.CoffeeDetails.route}/{coffeeId}",
            arguments = listOf(
                navArgument(name = "coffeeId") {
                    type = NavType.StringType
                }
            )
        ) {
            val id = it.arguments?.getString("coffeeId")
            val coffee = coffees?.first { coffee -> (coffee.id == id) }

            CoffeeDetailsScreen(
                coffee = coffee,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    TopAppBar(
        modifier = Modifier.height(50.dp),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(14.dp),
            )
        },
        scrollBehavior = scrollBehavior
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeeAppLBGTheme {
        CoffeeMainScreen()
    }
}

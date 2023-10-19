package com.app.lbgtest.coffee.presentations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.lbgtest.coffee.presentations.coffeelist.CoffeeListViewModel
import com.app.lbgtest.coffee.ui.theme.CoffeeAppLBGTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoffeeHomeScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeAppLBGTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    CoffeeMainScreen("app screen")
                }
            }
        }
    }
}

@Composable
fun CoffeeMainScreen(name: String, modifier: Modifier = Modifier) {
    val viewModel: CoffeeListViewModel = hiltViewModel()

    Text(
        text = "Welcome to coffee $name!------", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeeAppLBGTheme {
        CoffeeMainScreen("Android")
    }
}
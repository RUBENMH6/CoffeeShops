package com.example.coffeeshops

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeeshops.ui.theme.CoffeeShopsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeShopsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController=rememberNavController()
                    val viewModel: CoffeeShopsViewModel = viewModel()
                    NavHost(
                        navController=navController, startDestination=Routes.CoffeeShops.route
                    ){
                        composable(Routes.CoffeeShops.route){ CoffeeShops(navController, viewModel) }
                        composable(Routes.CoffeeShop.route){ CoffeeShop(navController, viewModel) }
                    }

                }
            }
        }
    }
}


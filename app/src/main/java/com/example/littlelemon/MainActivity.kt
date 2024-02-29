package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.Destinations.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}
@Composable
fun MyBottomNavigation (navController: NavController) {
    val items = listOf(Home, Menu, Location)
    var currentDestination by remember { mutableStateOf(Home) }
    BottomNavigation() {
        items.forEachIndexed { index, destination ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = destination.icon), contentDescription = null) }, // Replace with your actual icon
                label = { Text(text = destination.title) },
                selected = currentDestination == destination,
                onClick = { currentDestination = destination as Home; navController.navigate(destination.route) }
            )
        }
    }
}
@Composable
fun MyApp() {
    val navController = rememberNavController()

    Scaffold(bottomBar = { MyBottomNavigation(navController = navController) }) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(navController = navController, startDestination = Home.route) {
                composable(Home.route) { HomeScreen() }
                composable(Menu.route) { MenuScreen() }
                composable(Location.route) { LocationScreen() }
            }
        }
    }
}

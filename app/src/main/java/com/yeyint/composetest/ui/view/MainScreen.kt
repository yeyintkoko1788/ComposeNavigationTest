package com.yeyint.composetest.ui.view

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yeyint.composetest.ui.theme.ComposeTestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController
){
    val screenList = listOf(
        Screen.Home,
        Screen.Category,
        Screen.Favourite,
        Screen.Profile)
//    var selectedScreen by remember {
//        mutableStateOf(screenList.first())
//    }

    val homeNavController = rememberNavController()
    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                bottomBar = {
                    val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    NavigationBar {
                        screenList.forEach { screen ->
                            NavigationBarItem(
                                icon = {
                                    Icon(
                                        getIconForScreen(screen = screen.route),
                                        contentDescription = null
                                    )
                                },
                                label = {
                                    Text(
                                        text = screen.route,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                },
                                selected = currentDestination?.route == screen.route,
                                onClick = {
//                                    Log.d("GCAPP",screen.route)
//                                    selectedScreen = screen
                                    homeNavController.navigate(screen.route) {
                                        popUpTo(homeNavController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }){ paddingValue ->
                NavHost(navController = homeNavController, startDestination = Screen.Home.route){
                    composable(route = Screen.Home.route){
                        HomeView(navController = navController, Modifier.padding(paddingValue))
                    }

                    composable(route = Screen.Category.route){
                        CategoryView(navController = navController, Modifier.padding(paddingValue))
                    }

                    composable(route = Screen.Favourite.route){
                        FavouriteView(navController = navController, Modifier.padding(paddingValue))
                    }

                    composable(route = Screen.Profile.route){
                        ProfileView(navController = navController, Modifier.padding(paddingValue))
                    }
                }
            }
//                }){
////                when(selectedScreen){
////                    "Home" -> {
////                        HomeView(navController = navController, Modifier.padding(it))
////                    }
////                    "Category" -> {
////                        CategoryView(navController = navController, Modifier.padding(it))
////                    }
////                    "Favourite" -> {
////                        FavouriteView(navController = navController, Modifier.padding(it))
////                    }
////                    "Profile" -> {
////                        ProfileView(navController = navController, Modifier.padding(it))
////                    }
////                    else ->{
////                        HomeView(navController = navController, Modifier.padding(it))
////                    }
//                }
            }
        }
}

fun getIconForScreen(screen: String): ImageVector {
    return when (screen) {
        "Home" -> Icons.Filled.Home
        "Category" -> Icons.Filled.AccountBox
        "Favourite" -> Icons.Filled.Favorite
        "Profile" -> Icons.Filled.Person
        else -> {
            Icons.Filled.Favorite
        }
    }

}

@Composable
@Preview
fun MainPreview(){
    MainScreen(navController = rememberNavController())
}
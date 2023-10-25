package com.yeyint.composetest.ui.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LaunchApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route){
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }

        composable(route = Screen.Main.route){
            MainScreen(navController = navController)
        }
        
        composable(route = Screen.MovieDetail.route){
            MovieDetailScreen(navController = navController)
        }
    }
}

sealed class Screen(val route : String){
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Main : Screen("main")
    object MovieDetail : Screen("movie_detail")
}
package com.yeyint.composetest.ui.view

import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yeyint.composetest.R
import com.yeyint.composetest.ui.theme.ComposeTestTheme

@Composable
fun SplashScreen(
    navController: NavController
) {

    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Image(
                painter = painterResource(id = R.drawable.gc_dark_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            )
        }
    }
    android.os.Handler(Looper.getMainLooper()).postDelayed({
        navController.navigate(Screen.Login.route) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    },2000)
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}
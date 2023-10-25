package com.yeyint.composetest.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yeyint.composetest.R
import com.yeyint.composetest.ui.theme.ComposeTestTheme

@Composable
fun ProfileView(
    navController: NavController,
    modifier: Modifier
){
    ComposeTestTheme {
        Surface(
            modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Profile", modifier = Modifier)
                Button(
                    onClick = {
                        navController.navigate(Screen.MovieDetail.route)
                    }
                ) {
                    Text(text = stringResource(id = R.string.btn_movie_detail))
                }
            }
        }
    }
}

@Composable
@Preview
fun ProfilePreview(){
    ProfileView(navController = rememberNavController(), Modifier)
}
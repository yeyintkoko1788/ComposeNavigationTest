package com.yeyint.composetest.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yeyint.composetest.ui.theme.ComposeTestTheme

@Composable
fun CategoryView(
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
                Text(text = "Category", modifier = Modifier)
            }
        }
    }
}

@Composable
@Preview
fun CategoryPreview(){
    CategoryView(navController = rememberNavController(), Modifier)
}
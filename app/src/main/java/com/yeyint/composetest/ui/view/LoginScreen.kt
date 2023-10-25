package com.yeyint.composetest.ui.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yeyint.composetest.R
import com.yeyint.composetest.ui.theme.ComposeTestTheme
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.SignatureException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController
) {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = Color.Red,
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                )
                Text(
                    text = stringResource(id = R.string.sign_in),
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                )
                Text(
                    text = stringResource(id = R.string.user_name),
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 90.dp, start = 24.dp)
                )
                TextField(
                    value = userName,
                    onValueChange = { newText ->
                        userName = newText
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Text,
                    ),
                    //label = { Text(text = stringResource(id = R.string.your_user_name)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, bottom = 8.dp)
                )
                Text(
                    text = stringResource(id = R.string.password),
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 24.dp)
                )
                TextField(
                    value = password,
                    onValueChange = { newText ->
                        password = newText
                    },
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    //label = { Text(text = stringResource(id = R.string.your_password)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, bottom = 8.dp)
                )
                Button(
                    onClick = {
                        navController.navigate(Screen.Main.route){
                            popUpTo(navController.graph.id){
                                inclusive = true
                            }
                        }
                    }
                ) {
                    Text(text = stringResource(id = R.string.sign_in))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewLoginScreen() {
    LoginScreen(rememberNavController())
}
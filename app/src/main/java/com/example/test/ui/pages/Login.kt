package com.example.test.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test.R
import com.example.test.network.NetworkOperations
import com.example.test.ui.theme.PinkLoginPage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread

@Composable
@Preview
fun Login(navController: NavController){
    val backgroundImage = painterResource(id = R.drawable.login)
    var login by remember { mutableStateOf("Login") }
    var password by remember { mutableStateOf("Password") }
    val networkOperation = NetworkOperations()
    Image(
        painter = backgroundImage,
        contentDescription = null,
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f),
        alpha = 0.9f,
        contentScale = ContentScale.Crop,
        alignment = Alignment.TopCenter,
    )
    Row(
        Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.22f)
                .background(color = PinkLoginPage, shape = RoundedCornerShape(40.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Login and continue your journey", fontSize = 16.sp)
            OutlinedTextField(
                value = login,
                onValueChange = {newText ->
                    login = newText},
                Modifier
                    .fillMaxWidth(0.9f),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(40.dp),
            )
            OutlinedTextField(
                value = password,
                onValueChange = {newText ->
                    login = newText},
                Modifier
                    .fillMaxWidth(0.9f),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(40.dp),
            )
            Button(
                onClick = {
                    GlobalScope.launch {
                       networkOperation.performLogin(login, password)
                    }
                    navController.navigate("main")
                },
                Modifier
                    .fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(40.dp),
            ) {
                Text(text = "Login", fontSize = 16.sp, textAlign = TextAlign.Left)
            }
        }
    }
}


package com.example.test.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.test.database.DatabaseViewModel
import com.example.test.ui.components.FullHistory
import com.example.test.ui.components.HistoryCard
import com.example.test.ui.components.MenuComponent
import com.example.test.ui.theme.Cyan

/*@Composable
fun HistoryScreen(navControler: NavController?, viewModel: DatabaseViewModel) {
    var showFirstComposable by remember { mutableStateOf(true) }
    if (showFirstComposable) {
        HistoryCard(viewModel) {
            showFirstComposable = false
        }
    }
    else{
        FullHistory(viewModel){
            showFirstComposable = true
        }
    }
}*/
@Composable
fun HistoryPage(navController: NavController, viewModel: DatabaseViewModel){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //MenuComponent(viewModel, navController)
        //Spacer(modifier = Modifier.height(10.dp))
        HistoryCard(viewModel = viewModel, navController = navController)
    }
}


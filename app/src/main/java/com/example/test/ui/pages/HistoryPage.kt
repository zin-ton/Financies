package com.example.test.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.test.database.DatabaseViewModel
import com.example.test.ui.components.FullHistory
import com.example.test.ui.components.HistoryCard

@Composable
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
}


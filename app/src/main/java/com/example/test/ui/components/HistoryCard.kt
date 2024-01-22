package com.example.test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.test.database.DatabaseViewModel
import com.example.test.ui.theme.Cyan
import com.example.test.ui.theme.Grey
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


@Composable
@OptIn(ExperimentalMaterial3Api::class)
@Preview
fun HistoryCard(viewModel: DatabaseViewModel = viewModel(), navController: NavController) {
    val allData by viewModel.allData.collectAsState()
    LaunchedEffect(Unit){
        viewModel.getAllData()
    }
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH)
    val formattedDateTime = currentDateTime.format(formatter)
    var money: Int
    money = 0
    for (i in allData) {
        money += i.summ
    }
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(0.95f)
            .wrapContentHeight(),
    ) {
        Column(
            Modifier
                .background(Cyan)
                .wrapContentHeight()
                .fillMaxWidth(0.95f),
        ) {
            Text("Wallet 1 transaction history", style = MaterialTheme.typography.bodyLarge)
            Row(
                Modifier
                    .background(Cyan)
                    .wrapContentHeight()
                    .fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(formattedDateTime, style = MaterialTheme.typography.bodyLarge)
                Text("Total: ${money} usd", style = MaterialTheme.typography.bodyLarge)
            }
            Divider(
                Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )
            if (allData.size >= 5) {
                for (i in allData.size-1 downTo  allData.size-5) {
                    CardComponent(id = allData[i].id)
                }
            } else {
                for (i in allData.size-1 downTo 0) {
                    CardComponent(id = allData[i].id)
                }
            }
            Row(
                Modifier
                    .background(Cyan)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Button(
                    onClick = {
                              navController.navigate("full_history")
                    },
                    colors = buttonColors(
                        contentColor = Color.Black,
                        containerColor = Grey,
                        disabledContainerColor = Cyan,
                        disabledContentColor = Color.Black
                    ),
                    modifier = Modifier.width(75.dp),
                    contentPadding = PaddingValues(2.dp)
                ) {
                    Text("View All", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
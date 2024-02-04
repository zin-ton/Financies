package com.example.test.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.test.database.Data
import com.example.test.database.DatabaseViewModel
import com.example.test.ui.theme.Cyan
import kotlinx.coroutines.launch

@Composable
@Preview
fun AddPage(navController: NavController, viewModel: DatabaseViewModel) {
    var expanded by remember { mutableStateOf(false) }
    var money by remember { mutableStateOf("Enter sum") }
    var selectedItem by remember { mutableStateOf("Select a type") }
    val items = listOf("Clothing", "Food", "Gas", "Medicine", "Rent", "Transport")

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.9f)
                .padding(16.dp)
                .background(Cyan),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Cyan),
        ) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
            ) {
                items.forEach { item ->
                    DropdownMenuItem({ Text(item) }, onClick = {
                        selectedItem = item
                        expanded = false
                    })
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .background(Color.LightGray)
                    .padding(16.dp)
            ) {
                Text(selectedItem)
            }
            Spacer(modifier = Modifier.size(10.dp))
            OutlinedTextField(
                value = money,
                onValueChange = {newText ->
                    money = newText},
                Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(40.dp),
            )
            Spacer(modifier = Modifier.size(10.dp))
            Button(
                onClick = {
                    val data = Data(id = 0,type = selectedItem, summ = money.toInt())
                    viewModel.viewModelScope.launch{
                        viewModel.insertData(data)
                    }
                    navController.navigate("main")
                },
                Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                shape = RoundedCornerShape(10.dp)
            ){
                Text(text = "Add")
            }
        }
    }
}
package com.example.test.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.room.Room
import com.example.test.R
import com.example.test.database.DatabaseViewModel
import com.example.test.ui.theme.Cyan
import androidx.lifecycle.viewmodel.compose.viewModel
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CardComponent(id : Int, viewModel: DatabaseViewModel = viewModel()){
    var component : Pair<String, Int>
    component = Pair("Food", 100)
    val allData by viewModel.allData.collectAsState()
    LaunchedEffect(Unit){
        viewModel.getAllData()
    }

    for(i in allData){
        if(i.id == id){
            component = Pair(i.type, i.summ)
            break
        }
    }
    var image = painterResource(id = R.drawable.gas)
    if(component.first.equals("Food")) {image = painterResource(id = R.drawable.food)}
    if(component.first.equals("Clothes")) {image = painterResource(id = R.drawable.clothing)}
    if(component.first.equals("Gas")) {image = painterResource(id = R.drawable.gas)}
    if(component.first.equals("Medicine")) {image = painterResource(id = R.drawable.medicine)}
    if(component.first.equals("Rent")) {image = painterResource(id = R.drawable.rent)}
    if(component.first.equals("Transport")) {image = painterResource(id = R.drawable.transport)}
    Row(
        Modifier
            .background(Cyan)
            .wrapContentHeight()
            .fillMaxWidth()
        ,
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = Modifier.size(4.dp))
        Image(painter = image, contentDescription = null, Modifier.size(40.dp, 40.dp))
        Row(
            Modifier
                .background(Cyan)
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = component.first,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "${component.second} USD",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
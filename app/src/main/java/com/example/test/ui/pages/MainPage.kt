package com.example.test.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.R
import com.example.test.database.DatabaseViewModel
import com.example.test.ui.components.MenuComponent
import com.example.test.ui.theme.Cyan


@Composable
@Preview
fun MainPage(viewModel: DatabaseViewModel){
    var image = painterResource(id = R.drawable.baseline_add_24)
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuComponent(viewModel)
        Spacer(modifier = Modifier.size(10.dp))
        //HistoryScreen(navControler = null, viewModel = viewModel)
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
           OutlinedButton(onClick = { /*TODO*/ },
               Modifier.size(50.dp),
               shape = CircleShape,
               colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Cyan, contentColor = Color.Black),
               border = BorderStroke(1.dp, Color.Black)
           ) {
               Icon(painter = image, contentDescription = null, Modifier.size(50.dp), tint = Color.Unspecified, )
           }
        }
    }
}
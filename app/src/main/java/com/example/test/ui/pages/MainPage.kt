package com.example.test.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.example.test.R
import com.example.test.database.DatabaseViewModel
import com.example.test.ui.components.MenuComponent
import com.example.test.ui.theme.Cyan
import com.example.test.ui.theme.Orange
import com.example.test.ui.theme.PastelPink
import com.example.test.ui.theme.Pink80
import com.example.test.ui.theme.Purple40
import com.example.test.ui.theme.Purple80
import com.example.test.ui.theme.PurpleGrey80
import com.example.test.ui.theme.YellowLight


@Composable
@Preview
fun MainPage(viewModel: DatabaseViewModel, navController: NavController) {
    var image = painterResource(id = R.drawable.baseline_add_24)
    val allData by viewModel.allData.collectAsState()
    LaunchedEffect(Unit){
        viewModel.getAllData()
    }
    var money: Int
    money = 0
    var clothing = 0;
    var food = 0;
    var gas = 0;
    var medicine = 0;
    var rent = 0;
    var transport = 0;
    for (i in allData) {
        money += i.summ
        if(i.type == "Clothing"){
            clothing += i.summ
        }
        if(i.type == "Food"){
            food += i.summ
        }
        if(i.type == "Gas"){
            gas += i.summ
        }
        if(i.type == "Medicine"){
            medicine += i.summ
        }
        if(i.type == "Rent"){
            rent += i.summ
        }
        if(i.type == "Transport"){
            transport += i.summ
        }
    }
    val pieChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice("Clothing", clothing.toFloat(), YellowLight),
            PieChartData.Slice("Food", food.toFloat(), PastelPink),
            PieChartData.Slice("Gas", gas.toFloat(), Purple80),
            PieChartData.Slice("Medicine", medicine.toFloat() , Orange),
            PieChartData.Slice("Rent", rent.toFloat() , PurpleGrey80),
            PieChartData.Slice("Transport", transport.toFloat() , Purple40)
        ),
        plotType = PlotType.Pie
    )
    val pieChartConfig = PieChartConfig(
        isSumVisible = true,
        isAnimationEnable = true,
        showSliceLabels = true,
        sliceLabelTextColor = Color.Black,
        sliceLabelTextSize = 17.sp,
        animationDuration = 1500,
        backgroundColor = Cyan,
        labelVisible = true,
        activeSliceAlpha = 0.7f
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //MenuComponent(viewModel, navController)
        //Spacer(modifier = Modifier.size(10.dp))
        //HistoryScreen(navControler = null, viewModel = viewModel)
        PieChart(
            modifier = Modifier
                .width(400.dp)
                .height(400.dp),
            pieChartData,
            pieChartConfig
        )
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            OutlinedButton(
                onClick = { navController.navigate("add") },
                Modifier.size(50.dp),
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Cyan,
                    contentColor = Color.Black
                ),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Icon(
                    painter = image,
                    contentDescription = null,
                    Modifier.size(50.dp),
                    tint = Color.Unspecified,
                )
            }


        }

    }
}
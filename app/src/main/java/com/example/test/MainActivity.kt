package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.test.ui.components.HistoryCard
import com.example.test.ui.components.MenuComponent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            var array = ArrayList<Pair<String, Int>>()
            array.add(Pair("Food", 100))
            array.add(Pair("Clothes", 150))
            array.add(Pair("Gas", 200))
            array.add(Pair("Medicine", 2050))
            array.add(Pair("Rent", 10000))
            array.add(Pair("Transport", 10500))
            array.add(Pair("Food", 100))
            array.add(Pair("Clothes", 150))
            array.add(Pair("Gas", 200))
            array.add(Pair("Medicine", 2050))
            array.add(Pair("Rent", 10000))
            array.add(Pair("Transport", 10500))
            array.add(Pair("Food", 100))
            array.add(Pair("Clothes", 150))
            array.add(Pair("Gas", 200))
            array.add(Pair("Medicine", 2050))
            array.add(Pair("Rent", 10000))
            array.add(Pair("Transport", 10500))
            array.add(Pair("Food", 100))
            array.add(Pair("Clothes", 150))
            array.add(Pair("Gas", 200))
            array.add(Pair("Medicine", 2050))
            array.add(Pair("Rent", 10000))
            array.add(Pair("Transport", 10500))
            array.add(Pair("Food", 100))
            array.add(Pair("Clothes", 150))
            array.add(Pair("Gas", 200))
            array.add(Pair("Medicine", 2050))
            array.add(Pair("Rent", 10000))
            array.add(Pair("Transport", 10500))
            DrawUI(array = array)
        }
    }
}

@Composable
fun DrawUI(array : ArrayList<Pair<String, Int>>){
    Row(
        Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        MenuComponent()
    }
}
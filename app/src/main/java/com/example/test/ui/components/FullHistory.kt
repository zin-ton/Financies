package com.example.test.ui.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.test.R
import com.example.test.ui.theme.Cyan
import com.example.test.ui.theme.Grey
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@Preview
fun FullHistory(array: ArrayList<Pair<String, Int>>){
    var money: Int
    money = 0
    for (i in array) {
        money += i.second
    }

    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH)
    val formattedDateTime = currentDateTime.format(formatter)
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .background(Cyan)
            .fillMaxHeight()
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
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState)
                .background(Cyan),
        ){
            for(i in array){
                var image = painterResource(id = R.drawable.gas)
                if(i.first.equals("Food")) {image = painterResource(id = R.drawable.food)
                }
                if(i.first.equals("Clothes")) {image = painterResource(id = R.drawable.clothing)
                }
                if(i.first.equals("Gas")) {image = painterResource(id = R.drawable.gas)
                }
                if(i.first.equals("Medicine")) {image = painterResource(id = R.drawable.medicine)
                }
                if(i.first.equals("Rent")) {image = painterResource(id = R.drawable.rent)
                }
                if(i.first.equals("Transport")) {image = painterResource(id = R.drawable.transport)
                }
                Row(
                    Modifier
                        .background(Cyan)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ){
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
                            text = i.first,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "${i.second} USD",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                Box(modifier = Modifier.fillMaxWidth().height(10.dp).background(Cyan))
            }
        }
    }
}
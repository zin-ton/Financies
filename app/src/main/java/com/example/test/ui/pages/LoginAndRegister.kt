package com.example.test.ui.pages

import android.graphics.Rect
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.R
import com.example.test.ui.theme.PinkLoginPage

@Composable
@Preview
fun LoginAndRegisterPage() {
    val backgroundImage = painterResource(id = R.drawable.chooseimg)
    Image(
        painter = backgroundImage,
        contentDescription = null,
        Modifier
            .fillMaxSize(),
        alpha = 0.9f,
        contentScale = ContentScale.Crop
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
                .fillMaxHeight(0.2f)
                .background(color = PinkLoginPage, shape = RoundedCornerShape(40.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Finance at Your Fingertips: Simplify", fontSize = 16.sp)
            Text(text = "Visualize, Optimize", fontSize = 16.sp)
            Button(
                onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(40.dp),
            ) {
                Text(text = "Register", fontSize = 16.sp, textAlign = TextAlign.Left)
            }
            Button(
                onClick = { /*TODO*/ },
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
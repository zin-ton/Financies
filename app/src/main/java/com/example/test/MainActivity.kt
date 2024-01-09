package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)
@Preview(showBackground = true, widthDp = 393, heightDp = 808)
@Composable
fun WhiteTheme() {
    var mainContainerColor by remember { mutableStateOf(Color(217, 217, 217, 255)) }
    var statisticsContainerColor by remember { mutableStateOf(Color(217, 217, 217, 255)) }
    var historyContainerColor by remember { mutableStateOf(Color(217, 217, 217, 255)) }
    var remindersContainerColor by remember { mutableStateOf(Color(217, 217, 217, 255)) }
    val grey = Color(217,217,217,255)
    val cyan = Color(198, 235,255, 255)
    val lexend = GoogleFont("Lexend")
    val lexendFamily = FontFamily(
        Font(googleFont = lexend, fontProvider = provider)
    )
    Column(
        Modifier
            .background(Color.White)
            .wrapContentHeight()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth()
                .fillMaxSize(0.04F)
                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    //TODO
                    mainContainerColor = cyan
                    statisticsContainerColor = grey
                    historyContainerColor = grey
                    remindersContainerColor = grey
                          },
                colors = buttonColors(
                    contentColor = Color.Black,
                    containerColor = mainContainerColor
                ),
                modifier = Modifier
                    .width(75.dp),
                contentPadding = PaddingValues(2.dp),
            ){
                Text(
                    "main",
                    fontSize = 17.sp,
                    fontFamily = lexendFamily,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(300),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Button(
                onClick = {
                    //TODO
                    mainContainerColor = grey
                    statisticsContainerColor = cyan
                    historyContainerColor = grey
                    remindersContainerColor = grey
                },
                colors = buttonColors(
                    contentColor = Color.Black,
                    containerColor = statisticsContainerColor
                ),
                modifier = Modifier
                    .width(100.dp),
                contentPadding = PaddingValues(2.dp),
            ){
                Text(
                    "statistics",
                    fontSize = 17.sp,
                    fontFamily = lexendFamily,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(300),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Button(
                onClick = {
                    //TODO
                    mainContainerColor = grey
                    statisticsContainerColor = grey
                    historyContainerColor = cyan
                    remindersContainerColor = grey
                },
                colors = buttonColors(
                    contentColor = Color.Black,
                    containerColor = historyContainerColor
                ),
                modifier = Modifier
                    .width(75.dp),
                contentPadding = PaddingValues(2.dp),
            ){
                Text(
                    "history",
                    fontSize = 17.sp,
                    fontFamily = lexendFamily,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(300),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Button(
                onClick = {
                    //TODO
                    mainContainerColor = grey
                    statisticsContainerColor = grey
                    historyContainerColor = grey
                    remindersContainerColor = cyan
                },
                colors = buttonColors(
                    contentColor = Color.Black,
                    containerColor = remindersContainerColor
                ),
                modifier = Modifier
                    .width(100.dp),
                contentPadding = PaddingValues(2.dp),
            ){
                Text(
                    "reminders",
                    fontSize = 17.sp,
                    fontFamily = lexendFamily,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(300),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
@Preview(showBackground = true, widthDp = 393, heightDp = 808)
fun Card(/*money : Int, types: Map<String, Int>*/){//TODO
    val money = 100
    val types = mapOf<String, Int>(
        "clothing" to 100,
        "food" to 75,
        "gas" to 74,
        "medicine" to 70,
        "rent" to 50,
        "transport" to 30
    )
    val cyan = Color(198, 235,255, 255)
    val lexend = GoogleFont("Lexend")
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH)
    val formattedDateTime = currentDateTime.format(formatter)
    val lexendFamily = FontFamily(
        Font(googleFont = lexend, fontProvider = provider)
    )
    val foodImage = painterResource(id = R.drawable.food)
    val clothingImage = painterResource(id = R.drawable.clothing)
    val gasImage = painterResource(id = R.drawable.gas)
    val medicineImage = painterResource(id = R.drawable.medicine)
    val rentImage = painterResource(id = R.drawable.rent)
    val transportImage = painterResource(id = R.drawable.transport)
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(0.95f)
            .wrapContentHeight(),
    ) {
        Column(
            Modifier
                .background(cyan)
                .wrapContentHeight()
                .fillMaxWidth(0.95f),
        ) {
            Text("Wallet 1 transaction history",
            fontSize = 18.sp,
            fontFamily = lexendFamily,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight(300))
            Row(
                Modifier
                    .background(cyan)
                    .wrapContentHeight()
                    .fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(formattedDateTime,
                    fontSize = 18.sp,
                    fontFamily = lexendFamily,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(300)
                )
                Text(
                    "Total: ${money} usd",
                    fontSize = 18.sp,
                    fontFamily = lexendFamily,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(300)
                )
            }
            Divider(
                Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )
            for((key, value) in types){
                val temp = when(key){
                    "clothing" -> Row(
                        Modifier
                            .background(cyan)
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = clothingImage,
                            contentDescription = null,
                            Modifier
                                .size(40.dp, 40.dp)
                        )
                        Row(
                            Modifier
                                .background(cyan)
                                .wrapContentHeight()
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "    clothing",
                                fontSize = 20.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                            Text(
                                text = "$value USD",
                                fontSize = 18.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                        }
                    }
                    "food" -> Row(
                        Modifier
                            .background(cyan)
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = foodImage,
                            contentDescription = null,
                            Modifier
                                .size(40.dp, 40.dp)
                        )
                        Row(
                            Modifier
                                .background(cyan)
                                .wrapContentHeight()
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "    food",
                                fontSize = 20.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                            Text(
                                text = "$value USD",
                                fontSize = 18.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                        }
                    }
                    "gas" -> Row(
                        Modifier
                            .background(cyan)
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = gasImage,
                            contentDescription = null,
                            Modifier
                                .size(40.dp, 40.dp)
                        )
                        Row(
                            Modifier
                                .background(cyan)
                                .wrapContentHeight()
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "    gas",
                                fontSize = 20.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                            Text(
                                text = "$value USD",
                                fontSize = 18.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                        }
                    }
                    "medicine" -> Row(
                        Modifier
                            .background(cyan)
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = medicineImage,
                            contentDescription = null,
                            Modifier
                                .size(40.dp, 40.dp)
                        )
                        Row(
                            Modifier
                                .background(cyan)
                                .wrapContentHeight()
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "    medicine",
                                fontSize = 20.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                            Text(
                                text = "$value USD",
                                fontSize = 18.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                        }
                    }
                    "rent" -> Row(
                        Modifier
                            .background(cyan)
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = rentImage,
                            contentDescription = null,
                            Modifier
                                .size(40.dp, 40.dp)
                        )
                        Row(
                            Modifier
                                .background(cyan)
                                .wrapContentHeight()
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "    rent",
                                fontSize = 20.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                            Text(
                                text = "$value USD",
                                fontSize = 18.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                        }
                    }
                    "transport" -> Row(
                        Modifier
                            .background(cyan)
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = transportImage,
                            contentDescription = null,
                            Modifier
                                .size(40.dp, 40.dp)
                        )
                        Row(
                            Modifier
                                .background(cyan)
                                .wrapContentHeight()
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "    transport",
                                fontSize = 20.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                            Text(
                                text = "$value USD",
                                fontSize = 18.sp,
                                fontFamily = lexendFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(300)
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

}
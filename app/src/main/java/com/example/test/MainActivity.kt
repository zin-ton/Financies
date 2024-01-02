package com.example.test

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
            .background(Color.Red)
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
fun Card(){//TODO/f
    val cyan = Color(198, 235,255, 255)
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.background(Color.White)
            .fillMaxWidth(0.95f)
            .wrapContentHeight(),
    ) {
        Column(
            Modifier
                .background(cyan)
                .wrapContentHeight()
                .fillMaxWidth(0.95f),
        ) {
            Text("adada")
        }
    }
}
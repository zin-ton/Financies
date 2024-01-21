package com.example.test.ui.components

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.test.database.DatabaseViewModel
import com.example.test.ui.pages.HistoryScreen
import com.example.test.ui.pages.MainPage
import com.example.test.ui.theme.Cyan
import com.example.test.ui.theme.Grey
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@Composable
@Preview(showBackground = false, widthDp = 800, heightDp = 800)
@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalPagerApi::class
)
fun MenuComponent(viewModel: DatabaseViewModel = viewModel()) {
    val tabList = listOf("Main", "History")
    val pagerState = rememberPagerState()
    var tabIndex by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    Column(
        Modifier
            .background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight(0.04F)
            .padding(start = 5.dp, end = 5.dp, top = 5.dp)
            .clip(RoundedCornerShape(5.dp)),
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = {
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, it)
                )
            },
            backgroundColor = Cyan.copy(alpha = 0.5f),
            modifier = Modifier
                .shadow(1.dp, ambientColor = Grey, shape = RoundedCornerShape(2.dp))
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = tabIndex == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                        tabIndex = index
                    },
                    text = {
                        Text(text = text, style = MaterialTheme.typography.bodyLarge)
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState
        ) { page ->
            when (page) {
                0 -> MainPage(viewModel = viewModel)
                1 -> HistoryScreen(navControler = null, viewModel = viewModel)
            }
        }
    }
}

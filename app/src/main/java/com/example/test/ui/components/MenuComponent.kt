package com.example.test.ui.components

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
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
fun MenuComponent() {
    val tabList = listOf("Main", "History")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
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
                            Modifier.pagerTabIndicatorOffset(pagerState,it)
                        )
            },
            backgroundColor = Cyan.copy(alpha = 0.5f),
            modifier = Modifier.shadow(1.dp, ambientColor = Grey,shape = RoundedCornerShape(2.dp)).zIndex(0.3f),
        ){
            tabList.forEachIndexed{index, text ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = text, style = MaterialTheme.typography.bodyLarge)
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,) {

        }
    }
}

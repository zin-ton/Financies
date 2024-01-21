package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import androidx.room.Database
import androidx.room.Room
import com.example.test.database.AppDatabase
import com.example.test.database.Data
import com.example.test.database.DatabaseViewModel
import com.example.test.database.MyDataDao
import com.example.test.ui.components.HistoryCard
import com.example.test.ui.components.MenuComponent
import com.example.test.ui.pages.MainPage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity(), ViewModelStoreOwner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val appDatabase = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database_name"
            ).build()
            // Then, obtain the MyDataDao from the AppDatabase instance
            val myDataDao: MyDataDao = appDatabase.dataDao()
            val viewModel = DatabaseViewModel(myDataDao)
            //DrawUI(viewModel = viewModel)
            MainPage(viewModel = viewModel)
        }
    }
}

@Composable
fun DrawUI(viewModel: DatabaseViewModel){
    Row(
        Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        //MainPage(viewModel = viewModel)
        MenuComponent(viewModel)
    }
}
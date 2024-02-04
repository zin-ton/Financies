package com.example.test

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Database
import androidx.room.Room
import com.example.test.database.AppDatabase
import com.example.test.database.Data
import com.example.test.database.DatabaseViewModel
import com.example.test.database.DatabaseViewModelFactory
import com.example.test.database.MyDataDao
import com.example.test.ui.components.FullHistory
import com.example.test.ui.components.HistoryCard
import com.example.test.ui.components.MenuComponent
import com.example.test.ui.pages.AddPage
import com.example.test.ui.pages.HistoryPage
import com.example.test.ui.pages.Login
import com.example.test.ui.pages.LoginAndRegisterPage
//import com.example.test.ui.pages.HistoryScreen
import com.example.test.ui.pages.MainPage
import com.example.test.ui.pages.RegisterPage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database_name"
        ).build()
    }
    private val myDataDao: MyDataDao by lazy {
        appDatabase.dataDao()
    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
//            val appDatabase = Room.databaseBuilder(
//                applicationContext,
//                AppDatabase::class.java, "database_name"
//            ).build()
            //val myDataDao: MyDataDao = appDatabase.dataDao()
            val viewModel: DatabaseViewModel = ViewModelProvider(
                this,
                DatabaseViewModelFactory(application, myDataDao)
            ).get(DatabaseViewModel::class.java)
            val navController = rememberNavController()
            val requestPermissionLauncher =
                rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                    if (isGranted) {
                    } else {

                    }
                }
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MenuComponent(viewModel, navController = navController)
                Spacer(modifier = Modifier.size(10.dp))
                NavHost(
                    navController = navController,
                    startDestination = "choose",
                ){
                    composable("main"){ navBackStackEntry ->
                        viewModel.updateTabIndex(0)
                        MainPage(viewModel = viewModel, navController)
                    }
                    composable("history"){navBackStackEntry ->
                        //HistoryScreen(navControler = navController, viewModel = viewModel)
                        viewModel.updateTabIndex(1)
                        HistoryPage(navController, viewModel)
                    }
                    composable("full_history"){navBackStackEntry ->
                        FullHistory(viewModel, navController)
                    }
                    composable("choose"){
                        LoginAndRegisterPage(navController = navController)
                    }
                    composable("login"){
                        Login(navController = navController)
                    }
                    composable("register"){
                        RegisterPage(navController = navController)
                    }
                    composable("add"){
                        navBackStackEntry -> AddPage(navController = navController, viewModel = viewModel)
                    }
                }
            }
//            MainPage(viewModel = viewModel, navController)

        }
    }
}

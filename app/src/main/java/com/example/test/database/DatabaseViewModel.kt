package com.example.test.database

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date

class DatabaseViewModel(private val myDataDao: MyDataDao) : ViewModel() {
    private val _allData = MutableStateFlow<List<Data>>(emptyList())
    val allData : StateFlow<List<Data>> = _allData.asStateFlow()
    /*constructor() : this(){
    }*/
    fun getAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            _allData.value = myDataDao.getAllData() ?: emptyList()
        }
    }
    suspend fun insertData(myData: Data) {
        withContext(Dispatchers.IO) {
            myDataDao.insert(myData)
        }
        getAllData()
    }
}
package com.example.test.database

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class DatabaseViewModelFactory(
    private val application: Application,
    private val myDataDao: MyDataDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DatabaseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DatabaseViewModel(application, myDataDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
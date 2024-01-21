package com.example.test.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import java.util.Date


@Entity(tableName = "my_table")
data class Data(
    @PrimaryKey(autoGenerate = true) val id : Int,
    var type : String,
    val summ : Int,
)
@Database(entities = [Data::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dataDao() : MyDataDao
}

@Dao
interface MyDataDao{
    @Insert
    suspend fun insert(data : Data)

    @Query("SELECT * FROM my_table WHERE id = :id")
    suspend fun getDataById(id: Int) : Data?

    @Query("SELECT * FROM my_table WHERE type = :type")
    suspend fun getDataByType(type: String) : List<Data>?

    @Query("SELECT * FROM my_table WHERE summ = :summ")
    suspend fun getDataBySumm(summ: Int) : List<Data>?

    @Query("SELECT * FROM my_table")
    suspend fun getAllData() : (List<Data>?)

    @Query("SELECT COUNT(*) FROM my_table")
    suspend fun getCount(): Int?
}
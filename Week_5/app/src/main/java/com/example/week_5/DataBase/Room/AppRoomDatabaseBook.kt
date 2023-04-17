package com.example.week_5.DataBase.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.week_5.DataBase.Room.DAO.AutorizationRoomDAO
import com.example.week_5.DataBase.Room.DAO.BookRoomDAO
import com.example.week_5.model.Authorization
import com.example.week_5.model.book

@Database(entities = [book::class],version = 4)
abstract class AppRoomDatabaseBook : RoomDatabase() {
    abstract fun getRoomDao(): BookRoomDAO
    companion object{
        @Volatile
        private var INSTANCE : AppRoomDatabaseBook? = null
        fun getInstance(context: Context) : AppRoomDatabaseBook{
            return if (AppRoomDatabaseBook.INSTANCE == null){
                AppRoomDatabaseBook.INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabaseBook::class.java,
                    "booksDatabaseWithPhotoAndSort"
                ).build()
                AppRoomDatabaseBook.INSTANCE as AppRoomDatabaseBook
            }
            else AppRoomDatabaseBook.INSTANCE as AppRoomDatabaseBook
        }
    }
}
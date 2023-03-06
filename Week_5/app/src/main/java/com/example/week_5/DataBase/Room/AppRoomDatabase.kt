package com.example.week_5.DataBase.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.week_5.DataBase.Room.DAO.AutorizationRoomDAO
import com.example.week_5.model.Authorization

@Database(entities = [Authorization::class],version = 1)
abstract class AppRoomDatabase : RoomDatabase(){
    abstract fun getRoomDao():AutorizationRoomDAO
    companion object{
        @Volatile
        private var INSTANCE : AppRoomDatabase? = null
        fun getInstance(context:Context) : AppRoomDatabase{
            return if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "clientsDatabase"
                ).build()
                INSTANCE as AppRoomDatabase
            }
            else INSTANCE as AppRoomDatabase
        }
    }
 }

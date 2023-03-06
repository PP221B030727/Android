package com.example.week_5.DataBase.Room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.week_5.model.Authorization

@Dao
interface AutorizationRoomDAO {
    @Query("SELECT * FROM clients_table")
    fun getAllUsers():LiveData<List<Authorization>>

    @Insert
    suspend fun addClients(auto : Authorization)

    @Update
    suspend fun updateClients(auto: Authorization)

    @Delete
    suspend fun deleteClients(auto: Authorization)
}
package com.example.week_5.DataBase.Room.repository

import androidx.lifecycle.LiveData
import com.example.week_5.DataBase.DatabaseRepository
import com.example.week_5.DataBase.Room.DAO.AutorizationRoomDAO
import com.example.week_5.model.Authorization

class RoomRepository(private  val autoRoomDao : AutorizationRoomDAO) : DatabaseRepository {
    override val readAll: LiveData<List<Authorization>>
        get() = autoRoomDao.getAllUsers()


    override suspend fun create(auto: Authorization, onSuccess: () -> Unit) {
        autoRoomDao.addClients(auto = auto)
        onSuccess()
    }

    override suspend fun update(auto: Authorization, onSuccess: () -> Unit) {
        autoRoomDao.updateClients(auto = auto)
        onSuccess()

    }

    override suspend fun delete(auto: Authorization, onSuccess: () -> Unit) {
        autoRoomDao.deleteClients(auto = auto)
        onSuccess()
    }
}
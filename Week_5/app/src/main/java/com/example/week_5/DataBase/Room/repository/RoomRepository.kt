package com.example.week_5.DataBase.Room.repository

import androidx.lifecycle.LiveData
import com.example.week_5.DataBase.DatabaseRepository
import com.example.week_5.DataBase.Room.DAO.AutorizationRoomDAO
import com.example.week_5.DataBase.Room.DAO.BookRoomDAO
import com.example.week_5.model.Authorization
import com.example.week_5.model.book

class RoomRepository(private  val autoRoomDao : AutorizationRoomDAO , private val bookRoomDao : BookRoomDAO ) : DatabaseRepository {
    override val readAllBook: LiveData<List<book>>
        get() = bookRoomDao.getAllBooks()

    override val readAll: LiveData<List<Authorization>>
        get() = autoRoomDao.getAllUsers()

    override  val readAllBookAsc : LiveData<List<book>>
        get() = bookRoomDao.getAllAscBooks()

    override  val readAllBooksDSC : LiveData<List<book>>
        get() = bookRoomDao.getAllDscBooks()

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

    override suspend fun createBook(bok: book, onSuccess: () -> Unit) {
        bookRoomDao.addBook(bok = bok)
        onSuccess()
    }

    override suspend fun updateBook(bok: book, onSuccess: () -> Unit) {
        bookRoomDao.updateBook(bok = bok)
        onSuccess()
    }
    override suspend fun deleteBook(bok: book, onSuccess: () -> Unit) {
        bookRoomDao.deleteBook(bok = bok)
        onSuccess()
    }
}
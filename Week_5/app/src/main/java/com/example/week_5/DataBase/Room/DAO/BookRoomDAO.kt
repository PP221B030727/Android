package com.example.week_5.DataBase.Room.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.week_5.model.book
@Dao
interface BookRoomDAO {
    @Query("SELECT * FROM Books_table")
    fun getAllBooks(): LiveData<List<book>>

    @Query("SELECT * FROM Books_table ORDER BY nameOfBook ASC")
    fun getAllAscBooks(): LiveData<List<book>>

    @Query("SELECT * FROM Books_table ORDER BY nameOfBook DESC")
    fun getAllDscBooks(): LiveData<List<book>>

    @Insert
    suspend fun addBook(bok : book)
    @Update
    suspend fun updateBook(bok: book)
    @Delete
    suspend fun deleteBook(bok: book)
}
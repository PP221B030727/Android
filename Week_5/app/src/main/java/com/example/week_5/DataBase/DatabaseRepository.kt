package com.example.week_5.DataBase

import androidx.lifecycle.LiveData
import com.example.week_5.model.Authorization
import com.example.week_5.model.book

interface DatabaseRepository {
    val readAll: LiveData<List<Authorization>>
    val readAllBook : LiveData<List<book>>
    val readAllBookAsc : LiveData<List<book>>
    val readAllBooksDSC : LiveData<List<book>>

    suspend fun create(auto : Authorization , onSuccess: ()->Unit)

    suspend fun update(auto : Authorization , onSuccess: ()->Unit)

    suspend fun delete(auto : Authorization , onSuccess: ()->Unit)

    suspend fun createBook(bok : book , onSuccess: () -> Unit)

    suspend fun updateBook(bok : book , onSuccess: () -> Unit)

    suspend fun deleteBook(bok : book , onSuccess: () -> Unit)
}
package com.example.week_5.DataBase

import androidx.lifecycle.LiveData
import com.example.week_5.model.Authorization

interface DatabaseRepository {
    val readAll: LiveData<List<Authorization>>

    suspend fun create(auto : Authorization , onSuccess: ()->Unit)

    suspend fun update(auto : Authorization , onSuccess: ()->Unit)

    suspend fun delete(auto : Authorization , onSuccess: ()->Unit)

}
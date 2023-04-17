package com.example.week_5.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients_table")
data class Authorization(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @ColumnInfo
    val FullName : String,
    @ColumnInfo
    val email : String,
    @ColumnInfo
    val password : String,
    @ColumnInfo
    val isAdmin : Boolean
)

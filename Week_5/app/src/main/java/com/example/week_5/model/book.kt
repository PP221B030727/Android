package com.example.week_5.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Books_table")
data class book(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @ColumnInfo
    val nameOfBook : String,
    @ColumnInfo
    val author : String,
    @ColumnInfo
    val count : Int,
    @ColumnInfo
    val price : Double,
    @ColumnInfo
    val description : String,
    @ColumnInfo
    val imageId : Int
//    @Ignore val image : Bitmap?
)

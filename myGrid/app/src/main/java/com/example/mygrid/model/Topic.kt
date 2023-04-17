package com.example.mygrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes var  txt : Int ,
    val aviable : Int,
    @DrawableRes var id : Int
)
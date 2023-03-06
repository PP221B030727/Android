package com.example.week_5.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.week_5.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale

@Composable

fun OptionMenu(){
    Image(painter = painterResource(
        id = R.drawable.photo_2023_02_12_22_37_17),
        contentDescription = "Bacground",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

}
package com.example.week_5.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.week_5.R
import com.example.week_5.model.Authorization

@Composable
fun Profile(
    user : Authorization,
    navController: NavController
) {
    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = Color.DarkGray // Change the primary color to red
        )
    ){
        Scaffold(
            topBar = {
                topBarProfile(navController = navController)
            }
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.photo_2023_02_13_03_31_06),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colors.onSecondary, CircleShape)
                )
                Spacer(modifier = Modifier.height(16.dp))
                ProfileHeader(fullName = user.FullName)
                Spacer(modifier = Modifier.height(16.dp))
                ProfileBio(email = user.email)
                Spacer(modifier = Modifier.height(16.dp))
                ProfileStats(isAdmin = user.isAdmin)
            }
        }
    }
}

@Composable
fun ProfileHeader(fullName: String) {
    Text(
        text = fullName,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun ProfileBio(email: String) {
    Text(
        text = email,
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.onBackground
    )
}

@Composable
fun ProfileStats(isAdmin: Boolean) {
    val text = if (isAdmin) "Admin" else "User"
    Text(
        text = text,
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onBackground
    )
}


@Composable
fun topBarProfile(
    navController: NavController
){
    TopAppBar(
        title = { IconButton(onClick = { navController.navigate("welcomeTwo") }) {
            Icon(Icons.Default.ArrowBack, "")
        } },
        actions = {

        }
    )
}
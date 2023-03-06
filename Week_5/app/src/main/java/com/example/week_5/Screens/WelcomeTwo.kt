package com.example.week_5.Screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.week_5.MainViewModel
import com.example.week_5.R


//@Preview(showBackground = true)
@Composable
//

fun welcomeTwo(navigateBack: () -> Unit , mViewModel : MainViewModel){
    Image(painter = painterResource(id = R.drawable.photo_2023_02_12_22_37_17),
        contentDescription = "Phone",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f),
        contentScale = ContentScale.FillBounds
    )
    var showMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current
    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = Color.DarkGray // Change the primary color to red
        )
    ){
        TopAppBar(
            title = { Text("My Book Shop") },
            actions = {
                IconButton(
                    onClick = { Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()}) {
                    Icon(Icons.Default.Favorite, "")
                }
                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(Icons.Default.MoreVert, "")
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }
                ) {
                    DropdownMenuItem(onClick = { Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show() }) {
                        Text(text = "Settings")
                    }
                    DropdownMenuItem(onClick = { Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show() }) {
                        Text(text = "Logout")
                    }
                    DropdownMenuItem(onClick = { Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show() }) {
                        Text(text = "Profile")
                    }
                }
            }
        )
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(start = 10.dp, top = 70.dp, end = 10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable._1xshlntztl__ac_uf1000_1000_ql80_),
                    contentDescription = "Phone",
                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Clean Code",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Clean Code: A Handbook of Agile Software Craftsmanship 1st Edition",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "$19.99",
                style = MaterialTheme.typography.h6,
                color = Color.Red
            )
        }
    }


    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(start = 10.dp, top = 470.dp, end = 10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tpp20),
                    contentDescription = "Phone",
                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "The Pragmatic Programmer",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "The Pragmatic Programmer, 20th Anniversary Edition",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "$29.99",
                style = MaterialTheme.typography.h6,
                color = Color.Red
            )
        }
    }




}

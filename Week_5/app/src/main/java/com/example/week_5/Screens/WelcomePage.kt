package com.example.week_5.Screens

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.week_5.MainViewModel
import com.example.week_5.MainViewModelFactory
import com.example.week_5.R
import com.example.week_5.Utils.TYPE_ROOM

@Composable
//@Preview(showBackground = true)
fun welcomePage(modifier : Modifier = Modifier.fillMaxSize(), navigateToSignIn : () -> Unit , navigateTosignUp : () -> Unit, mViewModel : MainViewModel,navController : NavController) {
//    println("This is - m -------" + mViewModel.Re)

    Image(
        painter = painterResource(id = R.drawable.photo_2023_02_12_22_37_17),
        contentDescription = "Phone",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxHeight(0.75f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
//                navController.navigate("signup")
                mViewModel.initDatabase(TYPE_ROOM){
                    navController.navigate("signup")
                }

            } ,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .width(250.dp)
                .height(60.dp)
        ) {

            Text(
                text = "Getting Started",
                color = Color.White
            )
        }
        Row() {
            val label = remember{ mutableStateOf("Log In") }
            val save = label.value
            Text(text = "already have an account ?",
                modifier = Modifier.padding(15.dp),
                color = Color.DarkGray
            )
            TextButton(onClick = {
                mViewModel.initDatabase(TYPE_ROOM){
                    navController.navigate("signin")
                }
            }){
                Text(save, fontSize = 10.sp, color = Color.Red)
            }

        }
    }
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo_2023_02_12_22_29_32_removebg_preview),
            contentDescription = "Logog",
            modifier = Modifier
                .width(240.dp)
                .height(240.dp)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,

        ) {
        Column(
        ) {
            Text(
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                text = "Welcome"
            )
        }
        Column {
            Text(text = "Create an account and access thousand ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "of cool stuffs",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
    }
}

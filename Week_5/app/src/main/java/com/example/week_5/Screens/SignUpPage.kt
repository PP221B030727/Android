package com.example.week_5.Screens

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.week_5.MainViewModel
import com.example.week_5.MainViewModelFactory
import com.example.week_5.Utils.TYPE_ROOM
import com.example.week_5.model.Authorization


@Composable
//@Preview(showBackground = true)
fun signUpPage(modifier : Modifier = Modifier.fillMaxSize(), navigateBack: () -> Unit , navigateSignIn : () -> Unit,mViewModel : MainViewModel , navController : NavController){
    val context = LocalContext.current
    val mViewModel : MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))




    Image(painter = painterResource(id = com.example.week_5.R.drawable.photo_2023_02_12_22_37_17),
        contentDescription = "Phone",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        Row(
            modifier = Modifier.padding(30.dp)
        ) {
            val label = remember{ mutableStateOf("Log In") }
            val save = label.value
            Text(text = "already have an account ?",
                modifier = Modifier.padding(15.dp),
                color = Color.DarkGray
            )
            TextButton(onClick = navigateSignIn){
                Text(save, fontSize = 10.sp, color = Color.Red)
            }

        }
    }




    Column(
        modifier = Modifier
            .fillMaxHeight(0.75f)
            .fillMaxWidth()
            .padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        val TextState = remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier.padding(3.dp),
            value = TextState.value,
            onValueChange = { it:String ->
                TextState.value = it
            },
            placeholder = {
                Text("Fullname")
            }
        )
        val TextState1 = remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier.padding(3.dp),
            value = TextState1.value,
            onValueChange = { it:String ->
                TextState1.value = it
            },
            placeholder = {
                Text("Email")
            }
        )
        val TextState2 = remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier.padding(3.dp),
            value = TextState2.value,
            onValueChange = { it:String ->
                TextState2.value = it
            },
            placeholder = {
                Text("Password")
            }
        )
        Text(text = "password must be at least 6 charactxer",
            fontSize = 10.sp,
            modifier = Modifier.padding(5.dp)
        )
        Button(
            onClick = {
                mViewModel.addAuthorization(auto = Authorization(FullName = TextState.value , email = TextState1.value, password = TextState2.value)){
                    navController.navigate("signIn")
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .width(250.dp)
                .height(60.dp)
        ) {
//            mViewModel.initDatabase(TYPE_ROOM){
//
//            }
//            db.add(TextState.value,TextState1.value,TextState2.value)
            Text(
                text = "Sign Up",
                color = Color.White
            )
//            mViewModel.addAuthorization(Authorization(1,TextState.value, TextState1.value,TextState2.value)){}




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
            painter = painterResource(id = com.example.week_5.R.drawable.photo_2023_02_12_22_29_32_removebg_preview),
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
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            text = "Sign Up Now",
            modifier = Modifier.padding(90.dp)


        )
    }
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(text = "Please fill the details and create account",
            modifier = Modifier.padding(60.dp),
        )
    }
}


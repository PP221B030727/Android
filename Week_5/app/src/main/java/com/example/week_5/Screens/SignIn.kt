package com.example.week_5.Screens

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.week_5.model.Authorization


@Composable
//@Preview(showBackground = true)
fun signIn(modifier : Modifier = Modifier.fillMaxSize(), navigateBack: () -> Unit,navigateSignUp : ()->Unit,navigateTwo:()->Unit,mViewModel : MainViewModel,navController : NavController){
    var x = false
//    println(x)
    val users = mViewModel.readAllUsers().observeAsState(listOf()).value
//    println(users.first().FullName)
//    println(users)
//    val users = mViewModel.readTest.observeAsState(listOf()).value



//    println("Количество Юзеров ->" + users)
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
            modifier = Modifier.padding(40.dp)
        ) {
            val label = remember{ mutableStateOf("Sign Up") }
            val save = label.value
            Text(text = "Don't have an account ?",
                modifier = Modifier.padding(15.dp),
                color = Color.DarkGray
            )
            TextButton(onClick = navigateSignUp){
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
        val TextState1 = remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier.padding(10.dp),
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
            modifier = Modifier.padding(10.dp),
            value = TextState2.value,
            onValueChange = { it:String ->
                TextState2.value = it
            },
            placeholder = {
                Text("Password")
            }
        )
        Text(text = "Forgot Password ?",
            fontSize = 15.sp,
            modifier = Modifier.padding(10.dp)
        )
//        var save = false
//        var x = db.findValue(TextState1.value,TextState2.value)
//        if(x!=null && x!=""){
//            save = true
//        }
        Button(
//            enabled = false,
            onClick = {
                if(checkEmail(TextState1.value,users)){
                    if(checkPassword(TextState2.value,users)){
                        navController.navigate("welcomeTwo")
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .width(250.dp)
                .height(60.dp),

            ) {
            Text(
                text = "Log in",
                color = Color.White
            )


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
            text = "Log In Now"
        )
        Text(
            text = "Please login to continue using our app",
            modifier = Modifier.padding(40.dp)
        )
    }
}


fun checkEmail(emailUser: String, userList: List<Authorization>): Boolean {
    for (i in userList){
        if(i.email.equals(emailUser)){
            return true
        }
    }
    return false
}
fun checkPassword(passw: String, userList: List<Authorization>): Boolean {
    for (i in userList){
        if(i.password.equals(passw)){
            return true
        }
    }
    return false
}

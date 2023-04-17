package com.example.week_5.Screens

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.week_5.Background
import com.example.week_5.MainViewModel
import com.example.week_5.MainViewModelFactory
import com.example.week_5.R
import com.example.week_5.model.Authorization


@Composable
fun signIn(
    modifier : Modifier = Modifier
        .fillMaxSize(),
    mViewModel : MainViewModel,
    navController : NavController,
    onUserChange : (Authorization)->Unit ,
    focusManager: FocusManager
){

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordTrue = false

    val users = mViewModel.readAllUsers()
        .observeAsState(listOf()).value
    if(checkEmailAndPassword(
            emailUser = email,
            passwordUser = password ,
            userList = users,
            onUserChange = onUserChange
        )
    ){
        isPasswordTrue = true
    }

//    println(user)


    Background()
//    println(users)
//    for(i in users){
//        mViewModel.deleteUsers(i){}
//    }
//    val books = mViewModel.readAllBooks().observeAsState(listOf()).value
//    println(books)
//    for(i in books){
//        mViewModel.deleteBooks(i){}
//    }
    descriptionSignin(
        navController = navController,
        dnt = R.string.dnt,
        signUp = R.string.signUp
    )
    loginingInputs(
        onEmail = {
            email = it
        },
        onPassword = {
            password = it
        },
        email = email,
        password = password ,
        eml = R.string.eml,
        pas = R.string.pas,
        forgot = R.string.forgot ,
        focusManager = focusManager
    )

    loginingButton(
        modifier = Modifier
            .fillMaxHeight(0.78f)
            .fillMaxWidth(),

        navController = navController,
        isPasswordTrue = isPasswordTrue,
        login = R.string.login
    )

    logoImage(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        removebg_preview = R.drawable.photo_2023_02_12_22_29_32_removebg_preview
    )
    logginingInfo(
        LinNow = R.string.LinNow,
        Pls = R.string.Pls
    )

}
@Composable
fun logginingInfo(
    @StringRes LinNow : Int,
    @StringRes Pls : Int

){
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
            text = stringResource(id = LinNow)
        )
        Text(
            text = stringResource(id = Pls),
            modifier = Modifier.padding(40.dp)
        )
    }
}


@Composable
fun descriptionSignin(
    navController : NavController,
    @StringRes dnt : Int,
    @StringRes signUp : Int
){
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
            Text(
                text = stringResource(id = dnt),
                modifier = Modifier.padding(15.dp),
                color = Color.DarkGray
            )
            TextButton(onClick = {
                navController.navigate("signUp")
            }){
                Text(text = stringResource(id = signUp), fontSize = 10.sp, color = Color.Red)
            }
        }
    }
}




@Composable
fun loginingInputs(
    onEmail : (String)-> Unit,
    onPassword : (String)-> Unit,
    email : String,
    password : String,
    @StringRes eml : Int,
    @StringRes pas : Int,
    @StringRes forgot : Int,
    focusManager : FocusManager

){
    Column(
        modifier = Modifier
            .fillMaxHeight(0.75f)
            .fillMaxWidth()
            .padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        TextField(
            modifier = Modifier.padding(10.dp),
            value = email,
            onValueChange = onEmail,
            placeholder = {
                Text(text = stringResource(id = eml))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
        )

        TextField(
            modifier = Modifier.padding(10.dp),
            value = password,
            onValueChange = onPassword,
            placeholder = {
                Text(text = stringResource(id = pas))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password ,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),

        )
        Text(
            text = stringResource(id = forgot),
            fontSize = 15.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}



@Composable
fun loginingButton(
    modifier: Modifier ,
    navController : NavController,
    isPasswordTrue : Boolean,
    @StringRes login : Int,

){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { navController.navigate("welcomeTwo") },
            enabled = isPasswordTrue,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .width(250.dp)
                .height(60.dp)
            )
        {
            Text(
                text = stringResource(id = login),
                color = Color.White
            )
        }
    }

}





private fun checkEmailAndPassword(
    emailUser: String,
    passwordUser : String ,
    userList: List<Authorization>,
    onUserChange: (Authorization) -> Unit,

): Boolean {
    for (i in userList){
        if(i.email.equals(emailUser) && i.password.equals(passwordUser)){
            onUserChange(i)
            return true
        }
    }
    return false
}


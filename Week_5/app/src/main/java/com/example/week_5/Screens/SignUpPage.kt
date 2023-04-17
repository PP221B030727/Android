package com.example.week_5.Screens

import android.app.Application
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.week_5.Background
import com.example.week_5.MainViewModel
import com.example.week_5.MainViewModelFactory
import com.example.week_5.R
import com.example.week_5.Utils.TYPE_ROOM
import com.example.week_5.model.Authorization
import com.example.week_5.model.book
import java.io.ByteArrayOutputStream


@Composable
fun signUpPage(
    modifier : Modifier = Modifier.fillMaxSize(),
    navController : NavController,
    focusManager: FocusManager
){
    val context = LocalContext.current
    val mViewModel : MainViewModel = viewModel(
        factory = MainViewModelFactory(context.applicationContext as Application)
    )
    var fullName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isLogginingInfoTrue by remember {
        mutableStateOf(false)
    }
    if(email!="" && password!=""){
        isLogginingInfoTrue = true
    }




    Background()

    logoImage(
        removebg_preview = R.drawable.photo_2023_02_12_22_29_32_removebg_preview
    )
    alreadyHave(
        navController = navController,
        ahaaccount = R.string.ahaaccount,
        login = R.string.login
    )
    signUpNow(
        signUpNow = R.string.signUpNow
    )
    signUpInputs(
        onFullNameChange = { fullName = it },
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        fullname = fullName,
        email = email,
        password = password,
        flname = R.string.fullname,
        eml = R.string.eml,
        pas = R.string.pas,
        focusManager = focusManager
    )

    passwordRecomendation(passwordRec = R.string.passwordRec)

    SignUpPageButton(
        navController = navController,
        mViewModel = mViewModel,
        fullname = fullName,
        email = email,
        password = password,
        signUp = R.string.signUp,
        isLogginingInfoTrue = isLogginingInfoTrue
    )

    plsFill(
        PleaseFillTheDetails = R.string.PleaseFillTheDetails
    )
}

@Composable
fun alreadyHave(
    navController : NavController,
    @StringRes ahaaccount : Int ,
    @StringRes login : Int,
    
){
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
            Text(
                text = stringResource(id = ahaaccount),
                modifier = Modifier.padding(15.dp),
                color = Color.DarkGray
            )
            TextButton(
                onClick = {
                    navController.navigate("signIn")
                }
            ){
                Text(text = stringResource(id = login), fontSize = 10.sp, color = Color.Red)
            }

        }
    }
}



@Composable
fun signUpNow(
    @StringRes signUpNow : Int
){
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = stringResource(id = signUpNow),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier.padding(90.dp)
        )
    }
}




@Composable
fun plsFill(
    @StringRes PleaseFillTheDetails : Int
){
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text =  stringResource(id = PleaseFillTheDetails),
            modifier = Modifier.padding(60.dp),
        )
    }
}


@Composable
fun signUpInputs(
    onFullNameChange: (String)->Unit,
    onEmailChange: (String)->Unit,
    onPasswordChange: (String)->Unit,
    fullname : String ,
    email : String ,
    password : String,
    @StringRes flname : Int,
    @StringRes eml : Int,
    @StringRes pas : Int,
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
            modifier = Modifier.padding(3.dp),
            value = fullname,
            onValueChange = onFullNameChange,
            placeholder = {
                Text(stringResource(id = flname))
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
            modifier = Modifier.padding(3.dp),
            value = email,
            onValueChange = onEmailChange,
            placeholder = {
                Text(stringResource(id = eml))
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
            modifier = Modifier.padding(3.dp),
            value = password,
            onValueChange = onPasswordChange,
            placeholder = {
                Text(stringResource(id = pas))
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
    }
}




@Composable
fun passwordRecomendation(
    @StringRes passwordRec : Int
){
    Column(
        modifier = Modifier
            .fillMaxHeight(0.80f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(text = stringResource(id = passwordRec),
            fontSize = 10.sp,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Composable
fun SignUpPageButton(
    navController:NavController,
    mViewModel:MainViewModel ,
    fullname: String,
    email: String,
    password: String,
    @StringRes signUp : Int,
    isLogginingInfoTrue : Boolean

){
    Column(
        modifier = Modifier
            .fillMaxHeight(0.90f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        Button(
            onClick = {
                mViewModel.addAuthorization(auto = Authorization(FullName = fullname , email = email, password = password , isAdmin = false)){
                    navController.navigate("signIn")
                }
//                mViewModel.addBook(bok = book(
//                    nameOfBook = "The praggmatic programmer",
//                    author = "Michel",
//                    count = 4,
//                    price = 173.2 ,
//                    description = "Very , Very  good Book",
//                    imageId = R.drawable.tpp20
//                )){
//
//                }
            },
            enabled = isLogginingInfoTrue,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .width(250.dp)
                .height(60.dp)
        ) {
            Text(
                text = stringResource(id = signUp),
                color = Color.White
            )
        }
    }
}
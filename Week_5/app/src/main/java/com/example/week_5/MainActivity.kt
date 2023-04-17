package com.example.week_5

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.week_5.DataBase.Room.AppRoomDatabase
import com.example.week_5.DataBase.Room.AppRoomDatabaseBook

//import com.example.week_5.Screens.signIn

//import com.example.week_5.Screens.signUpPage

import com.example.week_5.Screens.*
import com.example.week_5.Utils.TYPE_ROOM
import com.example.week_5.model.Authorization
import com.example.week_5.model.book
import com.example.week_5.ui.theme.Week_5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week_5Theme{
                BookShopApp()
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun BookShopApp(){
    val context = LocalContext.current
    val navController = rememberNavController()
    val mViewModel : MainViewModel = viewModel(
        factory = MainViewModelFactory(context.applicationContext as Application)
    )
    val focusManager = LocalFocusManager.current


    var Book by remember {
        mutableStateOf(book(0 ,"","",0,0.0,"",0))
    }
    var user by remember {
        mutableStateOf(Authorization(
            id = 0 ,
            FullName = "" ,
            email = "" ,
            password = "" ,
            isAdmin = false)
        )
    }


    NavHost(navController =  navController, startDestination = "welcome") {
        composable("welcome") {
            welcomePage(
                mViewModel = mViewModel,
                navController = navController
            )
        }

        composable("signin") {
            signIn(
                mViewModel = mViewModel,
                navController = navController,
                onUserChange = { user = it },
                focusManager = focusManager
            )
        }

        composable("signup"){
            signUpPage(
                navController = navController,
                focusManager = focusManager
            )
        }

        composable("welcomeTwo"){
            welcomeTwo(
                navController = navController ,
                mViewModel = mViewModel,
                user = user,
                onBookChange = {
                    Book = it
                }
            )
        }
        composable("search"){
            searchScreen(
                navController = navController,
                mViewModel = mViewModel,
                focusManager = focusManager,
                onBookChange = {Book = it}
            )
        }
        composable("profile"){
            Profile(
                user = user,
                navController = navController
            )
        }
        composable("addingBook"){
            addPage(
                navController = navController,
                mViewModel = mViewModel
            )
        }
        composable("deleteBook"){
            deletePage(navController = navController , mViewModel = mViewModel)
        }
        composable("upd"){
            updatePage(navController = navController, mViewModel = mViewModel)
        }
        composable("bookPage"){
            bookPage(navController = navController, book = Book)
        }
    }
}
@Composable
fun Background(
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(id = R.drawable.photo_2023_02_12_22_37_17),
        contentDescription = "Phone",
        modifier = modifier
            .fillMaxSize()
            .alpha(0.5f),
        contentScale = ContentScale.FillBounds
    )
}

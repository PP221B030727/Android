package com.example.week_5

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//import com.example.week_5.Screens.signIn

//import com.example.week_5.Screens.signUpPage

import com.example.week_5.Screens.*
import com.example.week_5.Utils.TYPE_ROOM

//@Suppress("UNUSED_EXPRESSION")
class MainActivity : ComponentActivity() {
//    public val db = Base()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            welcomeTwo()

            val context = LocalContext.current
            val mViewModel : MainViewModel =
                viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
            val navController = rememberNavController()
            NavHost(navController =  navController, startDestination = "welcome") {
                composable("welcome") {
                    welcomePage(navigateToSignIn = { navController.navigate("signin") },
                        navigateTosignUp = { navController.navigate("signUp")},
                        mViewModel = mViewModel,
                        navController = navController
                    )
                }
                composable("signin") {
                    signIn(navigateBack = { navController.popBackStack("welcome", inclusive = true)} ,
                        navigateSignUp = { navController.navigate("signUp") } ,
                        navigateTwo = {navController.navigate("welcomeTwo")},
                        mViewModel = mViewModel,
                        navController = navController
                    )
                }
                composable("signup"){
                    signUpPage(navigateBack = { navController.popBackStack("welcome", inclusive = true)} ,
                        navigateSignIn = { navController.navigate("signIn") },
                        mViewModel = mViewModel,
                        navController = navController
                    )
                }
                composable("welcomeTwo"){
                    welcomeTwo(navigateBack = { navController.popBackStack("welcome", inclusive = true)},
                        mViewModel = mViewModel
                    )
                }
            }
        }
    }

}

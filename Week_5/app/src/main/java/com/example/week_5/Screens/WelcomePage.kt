package com.example.week_5.Screens

import android.app.Application
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.week_5.Background
import com.example.week_5.MainViewModel
import com.example.week_5.MainViewModelFactory
import com.example.week_5.R
import com.example.week_5.Utils.TYPE_ROOM

@Composable
fun welcomePage(
    mViewModel : MainViewModel,
    navController : NavController ,
    modifier: Modifier = Modifier
) {
    Background()
    settongsAut(
        mViewModel = mViewModel ,
        navController = navController ,
        modifier = modifier,
        getSt = R.string.getSt ,
        ahaaccount = R.string.ahaaccount,
        login = R.string.login
    )
    logoImage(
        modifier = modifier,
        removebg_preview = R.drawable.photo_2023_02_12_22_29_32_removebg_preview
    )
    descriptionApp(
        modifier,
        wel = R.string.wel,
        cranAc = R.string.cranAc,
        ofCool = R.string.ofCool
    )
}


@Composable
fun settongsAut(
    mViewModel : MainViewModel,
    navController : NavController,
    modifier: Modifier = Modifier,
    @StringRes getSt : Int,
    @StringRes ahaaccount :Int,
    @StringRes login : Int
){
    Column(
        modifier = modifier
            .fillMaxHeight(0.75f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                mViewModel.initDatabase(TYPE_ROOM){
                    navController.navigate("signup")
                }
            } ,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.DarkGray
            ),
            modifier = Modifier
                .width(250.dp)
                .height(60.dp)
        ) {

            Text(
                text = stringResource(
                    id = getSt
                ),
                color = Color.White
            )
        }
        Row{
            Text(
                text = stringResource(
                    id = ahaaccount
                ),
                modifier = Modifier.padding(15.dp),
                color = Color.DarkGray
            )
            TextButton(
                onClick = {
                    mViewModel.initDatabase(TYPE_ROOM){
                        navController.navigate("signin")
                    }
                }
            )
            {
                Text(
                    text = stringResource(
                        id = login
                    ),
                    fontSize = 10.sp, color = Color.Red
                )
            }
        }
    }
}



@Composable
fun logoImage(
    modifier: Modifier = Modifier ,
    @DrawableRes removebg_preview : Int
){
    Column(
        modifier = modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = removebg_preview
            ),
            contentDescription = "Logog",
            modifier = Modifier.width(240.dp).height(240.dp)
        )
    }
}

@Composable
fun descriptionApp(
    modifier: Modifier = Modifier,
    @StringRes wel : Int,
    @StringRes cranAc : Int,
    @StringRes ofCool : Int
){
    Column(
        modifier = modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,

        ) {
        Column{
            Text(
                text = stringResource(
                    id = wel
                ),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }
        Column{
            Text(
                text = stringResource(
                    id = cranAc
                ),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = stringResource(
                    id = ofCool
                ),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
    }
}

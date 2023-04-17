package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                artScreen()
            }
        }
    }
}
@Composable
fun artScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        card()
    }
}
@Preview(showBackground = true)
@Composable
fun card(){
    var cnt by remember {
        mutableStateOf(0)
    }
//    Text(text = "$cnt")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(cnt){

            0 -> {
                artPhoto(R.drawable.lemon_tree)
                artisitInfo(R.string.ttl,R.string.artisi)
            }
            1 -> {
                artPhoto(R.drawable.lemon_squeeze)
                artisitInfo(R.string.ttl,R.string.artisi)
            }
            2 -> {
                artPhoto(R.drawable.lemon_drink)
                artisitInfo(R.string.ttl,R.string.artisi)
            }
            3 -> {
                artPhoto(R.drawable.lemon_restart)
                artisitInfo(R.string.ttl,R.string.artisi)
            }
        }

        Buttons(
            onClickNxt = {
                cnt += 1
                if(cnt > 3){
                    cnt = 3
                }
            },
            onClickPrv = {
                cnt -= 1
                if(cnt < 0){
                    cnt = 0
                }
            }
        )
    }
}

@Composable
fun artPhoto(
    drawableResourceId: Int
){
    Image(
        painter = painterResource(id = drawableResourceId),//R.drawable.lemon_drink
        contentDescription = "lemonade" ,
        modifier = Modifier.padding(10.dp).border(width = 1.dp, color = Color.DarkGray).shadow(2.dp) ,

    )
}

@Composable
fun artisitInfo(
    firstId : Int,
    secondId : Int
){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .width(160.dp)
            .border(width = 1.dp, color = Color.DarkGray)
            .shadow(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = firstId), //R.string.ttl
        )
        Text(
            text = stringResource(id =secondId), //R.string.artisi
        )
    }
}
@Composable
fun Buttons(
    onClickNxt : () -> Unit,
    onClickPrv : () -> Unit
){
    Row(modifier = Modifier.padding(10.dp)) {
        Button(
            onClick = onClickPrv,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.001f)

            ) {
            Text(text = stringResource(id = R.string.prv))
        }
        Button(
            onClick = onClickNxt,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.001f)
        ) {
            Text(text = stringResource(id = R.string.nxt))
        }
    }
}
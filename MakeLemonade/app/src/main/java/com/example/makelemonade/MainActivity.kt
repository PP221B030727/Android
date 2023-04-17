package com.example.makelemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makelemonade.ui.theme.MakeLemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeLemonadeTheme {
                Lemonade()
            }
        }
    }
}

@Composable
fun Lemonade() {
    var cur by remember {
        mutableStateOf(1)
    }
    var rnd by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center) ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(cur){
            1 -> LemonadeAndImage(
                textLabelResourceId = R.string.LemonTree,
                drawableResourceId = R.drawable.lemon_tree,
                contentDescriptionResourceId = R.string.LemonTree,
                onImageClick = {
                    cur = 2
                    rnd = (0..4).random()
                    println(rnd);
                })
            2-> LemonadeAndImage(
                textLabelResourceId = R.string.Lemon,
                drawableResourceId =  R.drawable.lemon_squeeze,
                contentDescriptionResourceId =  R.string.Lemon,
                onImageClick = {
                    rnd-- ;
                    if(rnd<=0){
                        cur = 3
                    }
                }
            )
            3 -> LemonadeAndImage(
                textLabelResourceId = R.string.GlassOfLemonade,
                drawableResourceId = R.drawable.lemon_drink,
                contentDescriptionResourceId = R.string.GlassOfLemonade,
                onImageClick = { cur = 4 })
            else -> LemonadeAndImage(
                textLabelResourceId = R.string.EmptyGlass,
                drawableResourceId = R.drawable.lemon_restart,
                contentDescriptionResourceId = R.string.EmptyGlass,
                onImageClick = { cur = 1  })
        }

    }
}

@Composable
fun LemonadeAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit, // обработка нажатий
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(textLabelResourceId),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = stringResource(contentDescriptionResourceId),
            modifier = Modifier
                .wrapContentSize()
                .clickable(
                    onClick = onImageClick
                )
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
        )
    }

}
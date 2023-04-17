package com.example.myapp

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip

import com.example.myapp.ui.theme.MyAppTheme
import androidx.compose.foundation.shape.CircleShape

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Modifier


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Text(text = "Hello")
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            LazyColumn(

                modifier = Modifier
                    .fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally
            ){
//                items(count = 100){
                itemsIndexed (
                    listOf("item 1" , "item 2" , "item 3" , "finish" )
                ){index , item ->
                    Text(
//                        text = "Item $index",
                        text = item ,
                        fontSize = 30.sp,
                        modifier = Modifier.padding(vertical = 30.dp)
                    )
                }
            }


//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//            LazyRow(
//
//                modifier = Modifier
//                    .fillMaxSize()
//            ){
////                items(count = 100){
//                itemsIndexed (
//                    listOf("item 1" , "item 2" , "item 3" , "finish" )
//                ){index , item ->
//                    Text(
////                        text = "Item $index",
//                        text = item ,
//                        fontSize = 30.sp,
//                        modifier = Modifier.padding(vertical = 30.dp)
//                    )
//                }
//            }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




            //список
//            Column(modifier = Modifier.verticalScroll(rememberScrollState())){//добавляем скролинг и запоминаем состояние
//                lisrItem(name = "Nursultan Turugeldiev", prof = "Proggrammer")
//                lisrItem(name = "ahjksdhasjdh", prof = "Proggrammer")
//                lisrItem(name = "zxcjzxkcxzczxc", prof = "Proggrammer")
//                lisrItem(name = "asasjsa iev", prof = "Proggrammer")
//                lisrItem(name = "Nursultan Turugeldiev", prof = "Proggrammer")
//                lisrItem(name = "ahjksdhasjdh", prof = "Proggrammer")
//                lisrItem(name = "zxcjzxkcxzczxc", prof = "Proggrammer")
//                lisrItem(name = "asasjsa iev", prof = "Proggrammer")
//                lisrItem(name = "Nursultan Turugeldiev", prof = "Proggrammer")
//                lisrItem(name = "ahjksdhasjdh", prof = "Proggrammer")
//                lisrItem(name = "zxcjzxkcxzczxc", prof = "Proggrammer")
//                lisrItem(name = "asasjsa iev", prof = "Proggrammer")
//                lisrItem(name = "Nursultan Turugeldiev", prof = "Proggrammer")
//                lisrItem(name = "ahjksdhasjdh", prof = "Proggrammer")
//                lisrItem(name = "zxcjzxkcxzczxc", prof = "Proggrammer")
//                lisrItem(name = "asasjsa iev", prof = "Proggrammer")
//                lisrItem(name = "Nursultan Turugeldiev", prof = "Proggrammer")
//                lisrItem(name = "ahjksdhasjdh", prof = "Proggrammer")
//                lisrItem(name = "zxcjzxkcxzczxc", prof = "Proggrammer")
//                lisrItem(name = "asasjsa iev", prof = "Proggrammer")
//                lisrItem(name = "Nursultan Turugeldiev", prof = "Proggrammer")
//                lisrItem(name = "ahjksdhasjdh", prof = "Proggrammer")
//                lisrItem(name = "zxcjzxkcxzczxc", prof = "Proggrammer")
//                lisrItem(name = "asasjsa iev", prof = "Proggrammer")
//                lisrItem(name = "Nursultan Turugeldiev", prof = "Proggrammer")
//                lisrItem(name = "ahjksdhasjdh", prof = "Proggrammer")
//                lisrItem(name = "zxcjzxkcxzczxc", prof = "Proggrammer")
//                lisrItem(name = "asasjsa iev", prof = "Proggrammer")
//                lisrItem(name = "Nursultan Turugeldiev", prof = "Proggrammer")
//                lisrItem(name = "ahjksdhasjdh", prof = "Proggrammer")
//                lisrItem(name = "zxcjzxkcxzczxc", prof = "Proggrammer")
//                lisrItem(name = "asasjsa iev", prof = "Proggrammer")
//            }








//            Row(
////                command + p
//                modifier = Modifier
//                    .background(color = Color.Blue)
//                    .fillMaxSize(),
//                horizontalArrangement = Arrangement.Center
////                horizontalArrangement = Arrangement.End
////                horizontalArrangement = Arrangement.SpaceAround
////                horizontalArrangement = Arrangement.SpaceBetween
////                horizontalArrangement = Arrangement.SpaceEvenly
//
//
////---------------------------------------------------------------------------------------
////                verticalAlignment = Alignment.CenterVertically
////                verticalAlignment = Alignment.Bottom
////                top , center , bottom
////                horizontalArrangement = Arrangement.SpaceAround,
////                verticalAlignment = Alignment.CenterVertically
//            )
//            {
//                newText("Hello")
//                newText(message = "Nursultan")
//                newText(message = "How are you")
//            }
//            Column(
//                modifier = Modifier.background(color = Color.Red).fillMaxHeight(0.5f),
//                verticalArrangement = Arrangement.Center,// we can use Space with arrangment
//                horizontalAlignment = Alignment.CenterHorizontally//start , center , end
////                horizontalAlignment = Alignment.End
//
////            we can use fill max size , fill max weight  , fill max Width 0.5 f
//            )
//            {
//                newText("Hello")
//                newText(message = "Nursultan")
//                newText(message = "How are you")
//            }
//
//        }

            // пробую поделить экран на 4 части и по центру прописать цвета

//            Row(
//                modifier = Modifier
//                    .background(Color.DarkGray)
//                    .fillMaxSize()
//            ){
//                Column(modifier = Modifier
//                    .background(Color.Green)
//                    .fillMaxWidth(0.5f)
//                    .fillMaxHeight(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.SpaceAround
//                    ) {
//                    newText(message = "Green")
//                }
//                Column(modifier = Modifier
//                    .background(Color.Yellow)
//                    .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.SpaceEvenly
//                    ) {
//                    newText(message = "Yellow")
//                }
//            }
//
//
//
//            Row(
//                modifier = Modifier
//                    .background(Color.Green)
//                    .fillMaxHeight(0.5f)
//                    .fillMaxWidth()
//            ){
//
//                Column(
//                    modifier = Modifier
//                        .background(Color.Red)
//                        .fillMaxWidth(0.5f)
//                        .fillMaxHeight(),
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    newText(message = "Red")
//                }
//                Column(
//                    modifier = Modifier
//                        .background(Color.Blue)
//                        .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    newText(message = "Blue")
//                }
//
//            }
//
//











        }
    }
//    @Preview(showBackground = true)
//    @Composable
//    fun newText(message : String){
//        Text(text = message)
//    ,
//Список
//    @Composable
//    private fun lisrItem(name : String , prof : String){
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp)  // расстянуть по высоте
////                .offset(x = 40.dp)  //отступ от оригинальной  позиций по оси x
////                .offset(y = 20.dp), //отступ от оригинальной  позиций по оси y
////                .clickable {
////                    Log.d("MY LOG", "CLICKED")
////                }
//                .pointerInput(Unit) {
////                                   detectDragGesturesAfterLongPress { change, dragAmount ->
////                                       Log.d("My Log" , "Long press : $dragAmount")
////
////                                       Log.d("My Log" , "Long press : $change")
////                                   }
////                                   detectTapGestures {
////                                       Log.d("My Log" ,  "Long press : $it")//выдает место положения
////                                   }
//                    detectHorizontalDragGestures { change, dragAmount ->
//                        Log.d("My Log", "Long press : $dragAmount")//отслежка по горизонталий
//                    }
//                },
//            shape = RoundedCornerShape(15.dp), // закругленные углы
//            elevation = 5.dp // эфект подьема
//
//        ) {
////            Box(modifiesaer = Modifier.fillMaxSize(),
////                contentAlignment = Alignment.Center
////                 ){
////                Text(text = "Hello")
////
////            }
//            Box(){
//                Row(verticalAlignment = Alignment.CenterVertically){
//                     Image(painter = painterResource(id = R.drawable.photo_2023_02_11_19_24_43),
//                         contentDescription = "Image",
//                         contentScale = ContentScale.Crop, //обрезать
//                         modifier = Modifier
//                             .padding(5.dp)
//                             .size(64.dp)
//                             .clip(CircleShape)
//                     )
//                    Column(modifier = Modifier.padding(start = 16.dp)) {
//                        Text(text = name)
//                        Text(text = prof)
//                    }
//
//
//                }
//            }
//        }
//    }
    //Список












}

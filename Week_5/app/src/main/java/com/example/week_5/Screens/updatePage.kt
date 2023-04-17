package com.example.week_5.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.week_5.MainViewModel
import com.example.week_5.R
import com.example.week_5.model.book

@Composable
fun updatePage(
    navController: NavController,
    mViewModel : MainViewModel
) {
    var ID by remember {
        mutableStateOf("")
    }
    var nameOfBook by remember {
        mutableStateOf("")
    }
    var author by remember {
        mutableStateOf("")
    }
    var count by remember {
        mutableStateOf(0)
    }
    var price by remember {
        mutableStateOf(0.0)
    }
    var description by remember {
        mutableStateOf("")
    }
    var imadgeID by remember {
        mutableStateOf(0)
    }
    screenUpdate(
        ID = ID,
        nameOfBook = nameOfBook,
        author = author,
        count = count,
        price = price,
        description = description,
        imadgeID = imadgeID,
        onIdChange = {
            ID = it
        },
        onNameChange = {
            nameOfBook = it
        },
        onAuthorChange = {
            author = it
        },
        onCountChange = {
            count = it.toInt()
        },
        onDescChange = {
            description = it
        },
        onImageChange = {
            imadgeID = it.toInt()
        },
        onPriceChange = {
            price = it.toDouble()
        },
        navController = navController,
        mViewModel = mViewModel
    )

}

@Composable
fun screenUpdate(
    ID : String,
    nameOfBook : String,
    author : String,
    count : Int ,
    price : Double,
    description : String ,
    imadgeID : Int,
    onIdChange : (String)->Unit,
    onNameChange : (String)->Unit,
    onAuthorChange : (String)->Unit,
    onCountChange : (String)->Unit,
    onPriceChange : (String)->Unit,
    onDescChange : (String)->Unit,
    onImageChange : (String)->Unit,
    mViewModel: MainViewModel,
    navController: NavController
){
    Column(Modifier.padding(16.dp)) {
        TextField(
            value = ID,
            onValueChange = onIdChange,
            label = { Text("ID of book") }
        )

        Spacer(Modifier.height(16.dp))
        TextField(
            value = nameOfBook,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )

        Spacer(Modifier.height(16.dp))
        TextField(
            value = author,
            onValueChange = onAuthorChange,
            label = { Text("Author") }
        )

        Spacer(Modifier.height(16.dp))
        TextField(
            value = count.toString(),
            onValueChange = onCountChange,
            label = { Text("Quantity") }
        )

        Spacer(Modifier.height(16.dp))
        TextField(
            value = price.toString(),
            onValueChange = onPriceChange,
            label = { Text("Price") }
        )

        Spacer(Modifier.height(16.dp))
        TextField(
            value = description,
            onValueChange = onDescChange,
            label = { Text("Description") }
        )

        Spacer(Modifier.height(16.dp))
        TextField(
            value = imadgeID.toString(),
            onValueChange = onImageChange,
            label = { Text("Image") }
        )

        Spacer(Modifier.height(32.dp))
        Button(
            onClick = {
                var theBook = book(
                    id = ID.toInt() ,
                    nameOfBook = nameOfBook ,
                    author = author,
                    price = price,
                    description = description,
                    imageId = R.drawable.tpp20,
                    count = count
                )
                mViewModel.updateBook(theBook){
                    navController.navigateUp()
                }
            }
        ) {
            Text("Update Book")
        }
    }
}
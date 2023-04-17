package com.example.week_5.Screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.week_5.MainViewModel
import com.example.week_5.model.book

@Composable
fun searchScreen(
    navController: NavController,
    mViewModel : MainViewModel,
    focusManager: FocusManager,
    onBookChange: (book) -> Unit,

){
    val context = LocalContext.current
    var Books = mViewModel.readAllBooks().observeAsState(listOf()).value

    var booksCopy = listOf<book>()


    var booksName by remember {
        mutableStateOf("")
    }

    booksCopy = Books.filter{ it.nameOfBook == booksName }


    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = Color.DarkGray // Change the primary color to red
        )
    ) {
        Scaffold(
            topBar = {
                topBarSearch(
                    navController = navController,
                    focusManager = focusManager ,
                    onValueChange = {
                        booksName = it
                    },
                    booksName = booksName
                )
            }
        ) {
            LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)){
                items(booksCopy){
                    BookItem(Book = it, onBookChange = onBookChange , navController = navController)
                }
            }
        }


    }

//    println(booksCopy)



}


@Composable
fun topBarSearch(
    navController: NavController,
    focusManager: FocusManager,
    onValueChange: (String) -> Unit,
    booksName: String
){
    TopAppBar(
        title = { IconButton(onClick = { navController.navigate("welcomeTwo") }) {
            Icon(Icons.Default.ArrowBack, "")
        } },
        actions = {
            InputField(
                focusManager = focusManager,
                onValueChange = onValueChange,
                booksName = booksName
            )
        }
    )
}
@Composable
fun InputField(
    focusManager: FocusManager,
    onValueChange:(String)->Unit,
    booksName : String
){
    Row(modifier = Modifier.width(340.dp).fillMaxHeight()) {
        TextField(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp)
                ),
            value = booksName,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            leadingIcon = { Icon(Icons.Filled.Search, "Search") },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Gray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.Black
            )

        )
    }
}
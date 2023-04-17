package com.example.week_5.Screens

import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.week_5.Background
import com.example.week_5.MainViewModel
import com.example.week_5.R
import com.example.week_5.model.Authorization
import com.example.week_5.model.book


@Composable
fun welcomeTwo(
    navController: NavController ,
    mViewModel : MainViewModel ,
    user : Authorization,
    onBookChange : (book)->Unit
){

    var showMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current

    var ascOrDesc by remember {
        mutableStateOf(0)
    }
    var Books = mViewModel.readAllBooks().observeAsState(listOf()).value
    if(ascOrDesc==0){
        Books = mViewModel.readAllBooks().observeAsState(listOf()).value
    }
    else if(ascOrDesc>0){
        Books = mViewModel.getAllAscBooks().observeAsState(listOf()).value
    }
    else{
        Books = mViewModel.getAllDscBooks().observeAsState(listOf()).value
    }

    println(user)
    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = Color.DarkGray // Change the primary color to red
        )
    ){
        Scaffold(
            topBar = {
                BookAppTopBar(
                    navController = navController,
                    showMenu = showMenu,
                    context = context ,
                    onClick = { showMenu = !showMenu },
                    onDismissRequest = { showMenu = false },
                    myBookShoop = R.string.myBookShoop,
                    set = R.string.set,
                    logout = R.string.logout,
                    profile = R.string.profile,
                    user = user,
                    onAscOrDesc = {
                        if(it){
                            ascOrDesc = 1
                        }
                        else{
                            ascOrDesc = -1
                        }
                    }

                )
            }
        ){
            LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
                items(Books){
                    BookItem(Book = it , onBookChange = onBookChange, navController = navController)
                }
            }
        }
    }


}


@Composable
fun BookAppTopBar(
    navController: NavController,
    showMenu : Boolean,
    context : Context,
    onClick : ()->Unit,
    onDismissRequest : ()->Unit,
    @StringRes myBookShoop : Int,
    @StringRes set : Int,
    @StringRes logout : Int,
    @StringRes profile : Int ,
    user : Authorization,
    onAscOrDesc : (Boolean)->Unit
){
    TopAppBar(
        title = { Text(text = stringResource(id = myBookShoop)) },
        actions = {
            SortButton(onSortSelected = onAscOrDesc)
            IconButton(
                onClick = {
                    navController.navigate("search"){
                        Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
                    }
                }) {
                Icon(Icons.Default.Search, "")
            }
            IconButton(
                onClick = onClick
            ) {
                Icon(Icons.Default.MoreVert, "")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = onDismissRequest
            ) {
                DropdownMenuItem(onClick = { Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show() }) {
                    Text(text = stringResource(id = set))
                }
                DropdownMenuItem(
                    onClick = {
                        navController.navigate("welcome"){
                            Toast.makeText(context, "Logout" , Toast.LENGTH_SHORT).show()
                        }
                    }
                ) {
                    Text(text = stringResource(id = logout))
                }
                DropdownMenuItem(onClick = {
                    navController.navigate("profile"){
                        Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text(text = stringResource(id = profile))
                }
                DropdownMenuItem(onClick = {
                    navController.navigate("addingBook"){
                        Toast.makeText(context, "Add book", Toast.LENGTH_SHORT).show()
                    }

                }) {
                    Text(text = stringResource(id = R.string.add))
                }
                if(user.isAdmin){
                    DropdownMenuItem(onClick = {
                        navController.navigate("deleteBook"){
                            Toast.makeText(context, "Delete book", Toast.LENGTH_SHORT).show()
                        }
                    }) {
                        Text(text = stringResource(id = R.string.delete))
                    }
                    DropdownMenuItem(onClick = {
                        navController.navigate("upd"){
                            Toast.makeText(context, "Update book", Toast.LENGTH_SHORT).show()
                        }

                    }) {
                        Text(text = stringResource(id = R.string.update))
                    }
                }
            }
        }
    )
}


@Composable
fun BookItem(
    modifier : Modifier = Modifier,
    Book : book,
    onBookChange: (book) -> Unit,
    navController: NavController
){
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp,


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            BookIcon(
                Book.imageId,
                Book = Book,
                onBookChange = onBookChange,
                navController = navController
            )
            BookInformation(
                name = Book.nameOfBook,
                author = Book.author,
                price = Book.price,
                count = Book.count,
                id = Book.id
            )
        }
    }
}


@Composable
fun BookIcon(
    @DrawableRes BookIcon: Int,
    modifier: Modifier = Modifier,
    Book : book,
    onBookChange: (book) -> Unit,
    navController: NavController
) {
    Image(
        modifier = modifier
            .size(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(20)).clickable(onClick = {
                navController.navigate("bookPage"){
                    onBookChange(Book)
                }
            })
        ,
        contentScale = ContentScale.Crop,
        painter = painterResource(BookIcon),
        contentDescription = null,

    )
}



@Composable
fun BookInformation(
    name : String,
    author : String ,
    price : Double,
    count : Int,
    modifier: Modifier = Modifier,
    id : Int
) {
    Column {
        Text(
            text = name,
            modifier = modifier.padding(top = 8.dp),
            style =  MaterialTheme.typography.h6
        )
        Text(
            text = "Author : " + author,
            style =  MaterialTheme.typography.body1
        )
        Text(
            text = "Price : " + price.toString() + "$",
            style =  MaterialTheme.typography.body2
        )
        Text(
            text = "Quantity : "+count.toString(),
            style =  MaterialTheme.typography.body2
        )
        Text(
            text = "ID : " + id.toString() ,
            style =  MaterialTheme.typography.body2
        )
    }
}

@Composable
fun SortButton(
    onSortSelected: (Boolean) -> Unit
) {
    var isChecked by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
                onSortSelected(isChecked)

            },
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
package com.example.week_5.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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
fun deletePage (
    navController: NavController,
    mViewModel : MainViewModel
) {
    var books = mViewModel.readAllBooks().observeAsState(listOf()).value
    var ID by remember {
        mutableStateOf("")
    }
    screenInfo(
        ID = ID,
        onIdChange = {ID = it},
        books = books,
        mViewModel = mViewModel,
        navController = navController
    )

}

@Composable
fun screenInfo(
    ID: String,
    onIdChange: (String) -> Unit,
    books: List<book>,
    mViewModel: MainViewModel,
    navController: NavController
) {
    val bookToDelete = books.find { it.id == ID.toIntOrNull() }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = ID,
            onValueChange = onIdChange,
            label = { Text("ID of book") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (bookToDelete != null) {
            Text(
                text = "Are you sure you want to delete the book \"${bookToDelete.nameOfBook}\"?",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        mViewModel.deleteBooks(bookToDelete) {
                            navController.navigateUp()
                        }
                    },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text("Yes")
                }

                Button(
                    onClick = { navController.navigateUp() },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text("No")
                }
            }
        } else {
            Text(
                text = "Book not found!",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

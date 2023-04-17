package com.example.week_5.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.week_5.MainViewModel
import com.example.week_5.R
import com.example.week_5.model.book

@Composable
fun addPage(
    navController: NavController,
    mViewModel: MainViewModel
) {
    val (name, setName) = remember { mutableStateOf("") }
    val (author, setAuthor) = remember { mutableStateOf("") }
    val (count, setCount) = remember { mutableStateOf(0) }
    val (price, setPrice) = remember { mutableStateOf(0.0) }
    val (description, setDescription) = remember { mutableStateOf("") }
    val (imageId, setImageId) = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = name,
            onValueChange = setName,
            label = { Text("Name of book") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = author,
            onValueChange = setAuthor,
            label = { Text("Author") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = count.toString(),
            onValueChange = { setCount(it.toIntOrNull() ?: 0) },
            label = { Text("Count") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = price.toString(),
            onValueChange = { setPrice(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = description,
            onValueChange = setDescription,
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = imageId.toString(),
            onValueChange = { setImageId(it.toIntOrNull() ?: 0) },
            label = { Text("Image ID") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to add book to database
        Button(
            onClick = {
                val newBook = book(
                    nameOfBook = name,
                    author = author,
                    count = count,
                    price = price,
                    description = description,
                    imageId = R.drawable.tpp20
                )
                mViewModel.addBook(bok = newBook) {
                    navController.navigateUp()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Add Book")
        }
    }
}
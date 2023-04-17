package com.example.week_5.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.week_5.model.book

@Composable
fun bookPage(navController: NavController, book: book) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = book.nameOfBook) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = book.imageId),
                    contentDescription = book.nameOfBook,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth().aspectRatio(1f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = book.nameOfBook, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Author: ${book.author}", style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Count: ${book.count}", style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Price: ${book.price}", style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = book.description, style = MaterialTheme.typography.body2)
            }
        }
    )
}
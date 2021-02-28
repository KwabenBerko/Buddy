package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Gender
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.components.PuppyListItem
import com.example.androiddevchallenge.ui.theme.Rubik
import androidx.navigation.compose.navigate

@ExperimentalFoundationApi
@Composable
fun PuppyListScreen(puppies: List<Puppy>, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Buddy!",
                        style = TextStyle(
                            fontSize = 21.sp,
                            fontFamily = Rubik,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.brown_700)
                        )
                    )
                },
                backgroundColor = Color.White
            )
        }, content = {
            LazyVerticalGrid(
                cells = GridCells.Adaptive(160.dp),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.background(Color(0xFFF4F2F2))
            ) {
                items(puppies) { puppy ->
                    PuppyListItem(puppy, onPuppyClicked = {
                        navController.navigate("puppies/${puppy.id}")
                    })
                }
            }

        }
    )


}



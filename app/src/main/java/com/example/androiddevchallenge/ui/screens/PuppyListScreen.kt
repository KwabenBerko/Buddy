package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun PuppyListScreen(navController: NavController){

    LazyColumn{
        items(count = 5){
            PuppyListItem()
        }
    }

}


@Composable
fun PuppyListItem(){
    Text(text = "A Puppy")
}


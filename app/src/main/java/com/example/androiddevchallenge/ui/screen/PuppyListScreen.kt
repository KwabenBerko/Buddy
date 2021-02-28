package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PuppyListScreen(){

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



@Preview
@Composable
fun PuppyListScreenPreview(){
    PuppyListScreen()
}

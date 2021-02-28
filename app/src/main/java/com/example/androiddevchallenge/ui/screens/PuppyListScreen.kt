package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.Rubik

@ExperimentalFoundationApi
@Composable
fun PuppyListScreen(navController: NavController) {

    val puppies = getPuppies()

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
                items(puppies) { puppy -> PuppyListItem(puppy) }
            }

        }
    )


}


@Composable
fun PuppyListItem(puppy: Puppy) {
    Card(
        shape = RoundedCornerShape(3.dp),
        elevation = 2.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .height(240.dp)
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(0.dp)) {
            Image(
                painter = painterResource(id = puppy.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = puppy.name,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.W600,
                        color = Color(0xFF575757),
                    )
                )
            }
        }
    }
}


fun getPuppies(): List<Puppy> {
    return listOf(
        Puppy(
            id = 1,
            name = "Archie",
            breed = "Havanese",
            description = "",
            gender = Gender.MALE,
            image = R.drawable.archie
        ),
        Puppy(
            id = 2,
            name = "Ariel",
            breed = "Poodle",
            description = "",
            gender = Gender.FEMALE,
            image = R.drawable.ariel
        ),
        Puppy(
            id = 3,
            name = "Mika",
            breed = "Labrador",
            description = "",
            gender = Gender.MALE,
            image = R.drawable.mika
        ),
        Puppy(
            id = 4,
            name = "Rocky",
            breed = "Bulldog",
            description = "",
            gender = Gender.MALE,
            image = R.drawable.rocky
        ),

        Puppy(
            id = 6,
            name = "Coco",
            breed = "Rottweiler",
            description = "",
            gender = Gender.FEMALE,
            image = R.drawable.coco
        ),
        Puppy(
            id = 7,
            name = "Roxy",
            breed = "Pomeranian",
            description = "",
            gender = Gender.FEMALE,
            image = R.drawable.roxy
        ),

        Puppy(
            id = 8,
            name = "Finn",
            breed = "Chihuahua",
            description = "",
            gender = Gender.MALE,
            image = R.drawable.finn
        ),

        )
}



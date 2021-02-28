package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.model.Gender
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.theme.Rubik

@Composable
fun PuppyListItem(puppy: Puppy, onPuppyClicked: (puppy: Puppy) -> Unit) {
    Card(
        shape = RoundedCornerShape(3.dp),
        elevation = 2.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .height(240.dp)
            .padding(6.dp)
            .fillMaxSize()
            .clickable { onPuppyClicked(puppy) }
    ) {
        Column(modifier = Modifier.padding(0.dp)) {
            Image(
                painter = painterResource(id = puppy.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(170.dp)
                    .fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column {
                    Text(
                        text = puppy.name,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = Rubik,
                            fontWeight = FontWeight.W600,
                            color = Color(0xFF575757),
                        )
                    )

                    Text(
                        text = puppy.breed,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = Rubik,
                            color = Color(0xFF575757),
                        )
                    )
                }

                Box(
                    modifier = Modifier
                        .background(
                            Color(color = if (puppy.gender == Gender.FEMALE) 0xFFFF087E else 0xFF03A9F4),
                            shape = CircleShape
                        )
                        .padding(2.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(17.dp),
                        imageVector = if (puppy.gender == Gender.FEMALE) Icons.Default.Female else Icons.Default.Male,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

            }
        }
    }
}
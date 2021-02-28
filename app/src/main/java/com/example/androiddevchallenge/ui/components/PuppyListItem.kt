/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.data.model.Sex
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
                            Color(color = if (puppy.sex == Sex.FEMALE) 0xFFFF087E else 0xFF03A9F4),
                            shape = CircleShape
                        )
                        .padding(2.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(17.dp),
                        imageVector = if (puppy.sex == Sex.FEMALE) Icons.Default.Female else Icons.Default.Male,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}

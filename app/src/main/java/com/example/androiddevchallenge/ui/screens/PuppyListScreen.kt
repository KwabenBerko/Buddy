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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.components.PuppyListItem
import com.example.androiddevchallenge.ui.theme.Rubik

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
                            color = colorResource(id = R.color.blue_700)
                        )
                    )
                },
                backgroundColor = Color.White
            )
        },
        content = {
            LazyVerticalGrid(
                cells = GridCells.Adaptive(160.dp),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.background(Color(0xFFF4F2F2))
            ) {
                items(puppies) { puppy ->
                    PuppyListItem(
                        puppy,
                        onPuppyClicked = {
                            navController.navigate("puppies/${puppy.id}")
                        }
                    )
                }
            }
        }
    )
}

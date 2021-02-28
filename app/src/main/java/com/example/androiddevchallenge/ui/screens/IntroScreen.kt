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

import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
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
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.Rubik

@Composable
fun IntroScreen(window: Window, navController: NavController) {

    SideEffect(
        effect = {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    )

    DisposableEffect(Unit) {
        onDispose {
            @Suppress("DEPRECATION")
            window.clearFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    Box {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.buddy_bg),
            contentScale = ContentScale.Crop,
            contentDescription = "Buddy App background image"
        )

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxHeight()
                .padding(all = 24.dp)
        ) {
            Column(modifier = Modifier.padding(top = 24.dp)) {
                Text(
                    text = "Buddy!",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 38.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "Adopt a puppy and change a homeless buddy's entire world.",
                    style = TextStyle(
                        color = Color.LightGray,
                        fontSize = 17.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            TextButton(
                onClick = {
                    navController.navigate("puppies")
                },
                modifier = Modifier
                    .padding(12.dp)
                    .height(52.dp)
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(3.dp))

            ) {
                Text(
                    text = "Start Adopting",
                    style = TextStyle(
                        color = colorResource(id = R.color.blue_700),
                        fontSize = 17.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

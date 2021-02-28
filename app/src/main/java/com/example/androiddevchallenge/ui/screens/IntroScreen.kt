package com.example.androiddevchallenge.ui.screens

import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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

    SideEffect(effect = {
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    })

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
            contentDescription = null
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
                    text = "Start Adopting", style = TextStyle(
                        color = colorResource(id = R.color.brown_700),
                        fontSize = 17.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

    }
}

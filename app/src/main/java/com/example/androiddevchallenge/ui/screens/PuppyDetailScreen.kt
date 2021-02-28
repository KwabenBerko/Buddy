package com.example.androiddevchallenge.ui.screens

import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
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
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Gender
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.theme.Rubik

@Composable
fun PuppyDetailScreen(puppy: Puppy, window: Window, navController: NavController) {

    SideEffect(effect = {
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )
    })

    DisposableEffect(Unit) {
        onDispose {
            @Suppress("DEPRECATION")
            window.clearFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.height(320.dp)) {
            Image(
                painter = painterResource(id = puppy.image),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                contentDescription = null
            )
            Box(
                modifier = Modifier
                    .padding(vertical = 30.dp, horizontal = 16.dp)
            ) {

                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }, modifier = Modifier
                        .background(color = Color.White, shape = CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        modifier = Modifier.size(28.dp),
                        tint = colorResource(id = R.color.brown_700),
                        contentDescription = null
                    )
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(18.dp)
                .fillMaxSize()
        ) {

            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = puppy.name,
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontFamily = Rubik,
                            fontWeight = FontWeight.W600,
                            color = Color(0xFF575757),
                        )
                    )

                    Box(
                        modifier = Modifier
                            .background(
                                Color(color = if (puppy.gender == Gender.FEMALE) 0xFFFF087E else 0xFF03A9F4),
                                shape = CircleShape
                            )
                            .padding(6.dp)
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(22.dp),
                            imageVector = if (puppy.gender == Gender.FEMALE) Icons.Default.Female else Icons.Default.Male,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }

                Text(
                    text = puppy.breed,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = Rubik,
                        color = Color(0xFF575757),
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = puppy.description)
            }



            TextButton(
                onClick = {
                    print("Adopt me button clicked!")
                },
                modifier = Modifier
                    .padding(12.dp)
                    .height(52.dp)
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.brown_500), RoundedCornerShape(3.dp))

            ) {
                Text(
                    text = "Adopt ${puppy.name}", style = TextStyle(
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

        }
    }
}
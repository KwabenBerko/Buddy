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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.PuppyRepository
import com.example.androiddevchallenge.ui.screens.IntroScreen
import com.example.androiddevchallenge.ui.screens.PuppyDetailScreen
import com.example.androiddevchallenge.ui.screens.PuppyListScreen
import com.example.androiddevchallenge.ui.theme.BuddyTheme

@ExperimentalFoundationApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BuddyTheme {
                val puppyRepository = PuppyRepository()
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "intro") {
                    composable("intro") {
                        IntroScreen(
                            window = window,
                            navController = navController
                        )
                    }
                    composable("puppies") {
                        PuppyListScreen(
                            puppies = puppyRepository.findAllPuppies(),
                            navController = navController
                        )
                    }

                    composable(
                        "puppies/{puppyId}",
                        arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val puppyId = backStackEntry.arguments!!.getInt("puppyId")
                        PuppyDetailScreen(
                            puppy = puppyRepository.findPuppyById(puppyId),
                            window = window,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

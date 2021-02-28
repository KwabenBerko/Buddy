package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class Puppy(
    val id: Int,
    val name: String,
    val gender: Gender,
    val breed: String,
    val description: String,
    @DrawableRes val image: Int
)
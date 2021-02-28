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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Gender
import com.example.androiddevchallenge.data.model.Puppy

class PuppyRepository {

    private companion object {
        const val DESCRIPTION =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempus eu nunc nec dapibus. Cras sit amet rhoncus ex, quis pharetra odio. Vivamus quis egestas lectus. Proin at elementum libero. Curabitur quam libero, semper placerat vestibulum ac, sollicitudin eu elit. Donec eu mi in leo laoreet rhoncus ut ullamcorper nisi."
        val PUPPIES = listOf(
            Puppy(
                id = 1,
                name = "Archie",
                breed = "Havanese",
                description = DESCRIPTION,
                gender = Gender.MALE,
                image = R.drawable.archie
            ),
            Puppy(
                id = 2,
                name = "Ariel",
                breed = "Poodle",
                description = DESCRIPTION,
                gender = Gender.FEMALE,
                image = R.drawable.ariel
            ),

            Puppy(
                id = 3,
                name = "Coco",
                breed = "Rottweiler",
                description = DESCRIPTION,
                gender = Gender.FEMALE,
                image = R.drawable.coco
            ),
            Puppy(
                id = 4,
                name = "Roxy",
                breed = "Pomeranian",
                description = DESCRIPTION,
                gender = Gender.FEMALE,
                image = R.drawable.roxy
            ),

            Puppy(
                id = 5,
                name = "Mika",
                breed = "Labrador",
                description = DESCRIPTION,
                gender = Gender.MALE,
                image = R.drawable.mika
            ),
            Puppy(
                id = 6,
                name = "Rocky",
                breed = "Bulldog",
                description = DESCRIPTION,
                gender = Gender.MALE,
                image = R.drawable.rocky
            ),

            Puppy(
                id = 7,
                name = "Finn",
                breed = "Chihuahua",
                description = DESCRIPTION,
                gender = Gender.MALE,
                image = R.drawable.finn
            ),
        )
    }

    fun findAllPuppies(): List<Puppy> {
        return PUPPIES
    }

    fun findPuppyById(id: Int): Puppy {
        return PUPPIES.first { it.id == id }
    }
}

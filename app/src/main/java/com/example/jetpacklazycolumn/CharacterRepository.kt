package com.example.jetpacklazycolumn

class CharacterRepository {
    fun getAllCharacters(): List<Character> {
        return listOf(
            Character(
                id = 0,
                name = "Spongbob",
                description = "Squared pants",
                category = "Artificial"
            ),
            Character(
                id = 1,
                name = "Superman",
                description = "The strongest man ever",
                category = "Artificial"
            ),
            Character(
                id = 2,
                name = "Aladin",
                description = "Wish maker",
                category = "Artificial"
            ),
            Character(
                id = 3,
                name = "Lion",
                description = "The lion king",
                category = "Animal"
            ),
            Character(
                id = 4,
                name = "Snake",
                description = "Be careful",
                category = "Animal"
            ),
            Character(
                id = 5,
                name = "Zebra",
                description = "Black and white",
                category = "Animal"
            ),
            Character(
                id = 6,
                name = "Bibi",
                description = "Former minister",
                category = "Person"
            ),
            Character(
                id = 7,
                name = "Dan Arieli",
                description = "Author",
                category = "Person"
            ),
            Character(
                id = 8,
                name = "Mike Tyson",
                description = "Boxer",
                category = "Person"
            )
        )
    }
}
package com.example.jetpacklazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacklazycolumn.ui.theme.JetpackLazyColumnTheme
import com.example.jetpacklazycolumn.ui.theme.Shapes
import com.example.jetpacklazycolumn.ui.theme.Typography

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackLazyColumnTheme {
                val characterRepository = CharacterRepository()
                val characters = characterRepository.getAllCharacters()
                val sections = listOf("Artificial", "Animal", "Person")
                var selectedRow by remember { mutableStateOf<Character?>(null) }.apply { this.value }

                LazyColumn {
                    sections.forEach { section ->
                        val charactersInCategory = characters.filter {
                            it.category == section
                        }
                        stickyHeader {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.LightGray)
                                    .padding(12.dp),
                                text = section,
                                fontSize = Typography.h6.fontSize,
                            )
                        }
                        items(items = charactersInCategory) {
                            Row(
                                modifier = Modifier
                                    .background(Color.White)
                                    .border(width = 1.dp, shape = Shapes.small, color = Color.Black)
                                    .fillMaxWidth()
                                    .padding(24.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Text(
                                    text = it.name,
                                    color = Color.Black,
                                    fontSize = Typography.h4.fontSize,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .clickable { selectedRow = it }
                                )
                            }
                            if (selectedRow != null && it == selectedRow) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxSize()
                                ) {
                                    Column {
                                        selectedRow?.let {
                                            //If state is not null display data
                                            Text(
                                                text = "Description: ${it.description}",
                                                color = Color.DarkGray,
                                                fontSize = Typography.h6.fontSize)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
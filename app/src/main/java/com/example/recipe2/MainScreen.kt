package com.example.recipe2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(onNavigate: (String) -> Unit) {
    BackgroundWrapper {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App Details Section
            Text(
                text = "Welcome to Recipe Finder App!",
                style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Discover and manage your favorite recipes easily! You can " +
                        "browse all recipes, add new ones, or remove recipes you no longer need. " +
                        "Let's make cooking simple and fun!",
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Navigation Buttons
            Button(onClick = { onNavigate("AllRecipes") }) {
                Text(text = "All Recipes")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onNavigate("AddRecipe") }) {
                Text(text = "Add Recipe")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onNavigate("DeleteRecipe") }) {
                Text(text = "Delete Recipe")
            }
        }
    }
}
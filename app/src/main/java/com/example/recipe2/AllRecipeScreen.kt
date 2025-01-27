package com.example.recipe2

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllRecipesScreen(viewModel: RecipeViewModel) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // Use a default background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "All Recipes",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            ) {
                items(viewModel.recipes) { recipe ->
                    Text(
                        text = recipe,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

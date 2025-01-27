package com.example.recipe2

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DeleteRecipeScreen(viewModel: RecipeViewModel) {
    val recipes = viewModel.recipes // List of recipes from ViewModel
    val context = LocalContext.current // Get the context inside a Composable function

    BackgroundWrapper {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Delete Recipe", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(recipes) { recipe ->
                    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                        Text(
                            text = recipe,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                        Button(onClick = {
                            viewModel.deleteRecipe(recipe)
                            Toast.makeText(context, "Recipe Deleted", Toast.LENGTH_SHORT).show()
                        }) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DeleteRecipeScreenPreview() {
    DeleteRecipeScreen(viewModel = RecipeViewModel())
}

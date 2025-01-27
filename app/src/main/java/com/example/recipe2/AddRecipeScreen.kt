package com.example.recipe2

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun AddRecipeScreen(viewModel: RecipeViewModel) {
    // State for user inputs
    val recipeName = remember { mutableStateOf("") }
    val recipeDescription = remember { mutableStateOf("") }

    // Get the context within the composable
    val context = LocalContext.current

    BackgroundWrapper {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Add New Recipe", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            // Recipe Name Input
            BasicTextField(
                value = recipeName.value,
                onValueChange = { recipeName.value = it },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                decorationBox = { innerTextField ->
                    if (recipeName.value.isEmpty()) {
                        Text("Enter Recipe Name", style = MaterialTheme.typography.bodyLarge)
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Recipe Description Input
            BasicTextField(
                value = recipeDescription.value,
                onValueChange = { recipeDescription.value = it },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                decorationBox = { innerTextField ->
                    if (recipeDescription.value.isEmpty()) {
                        Text("Enter Recipe Description", style = MaterialTheme.typography.bodyLarge)
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Add Recipe Button
            Button(onClick = {
                if (recipeName.value.isNotEmpty() && recipeDescription.value.isNotEmpty()) {
                    // Add recipe and show a toast
                    viewModel.addRecipe(recipeName.value, recipeDescription.value)
                    Toast.makeText(context, "Recipe Added", Toast.LENGTH_SHORT).show()
                } else {
                    // Show error toast
                    Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Add Recipe")
            }
        }
    }
}

package com.example.recipe2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RecipeNavGraph(navController: NavHostController) {
    // Get the viewModel instance
    val recipeViewModel: RecipeViewModel = viewModel()

    // Apply background to the entire NavGraph
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // Use a default background
    ) {
        NavHost(
            navController = navController,
            startDestination = "MainScreen",
            modifier = Modifier.fillMaxSize()
        ) {
            composable("MainScreen") {
                MainScreen { route -> navController.navigate(route) }
            }
            composable("AllRecipes") {
                AllRecipesScreen(viewModel = recipeViewModel) // Passing viewModel
            }
            composable("AddRecipe") {
                AddRecipeScreen(viewModel = recipeViewModel) // Passing viewModel
            }
            composable("DeleteRecipe") {
                DeleteRecipeScreen(viewModel = recipeViewModel) // Passing viewModel
            }
        }
    }
}

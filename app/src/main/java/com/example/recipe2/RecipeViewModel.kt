package com.example.recipe2

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class RecipeViewModel : ViewModel() {
    // List of recipes
    private val _recipes = mutableStateListOf<String>()
    val recipes: List<String> get() = _recipes

    // Add Recipe
    fun addRecipe(name: String, description: String) {
        _recipes.add("$name - $description")
    }

    // Delete Recipe
    fun deleteRecipe(recipe: String) {
        _recipes.remove(recipe)
    }
}

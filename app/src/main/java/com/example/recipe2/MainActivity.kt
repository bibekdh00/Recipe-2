package com.example.recipe2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.recipe2.ui.theme.Recipe2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Recipe2Theme {
                val navController = rememberNavController()
                RecipeNavGraph(navController = navController)
            }
        }
    }
}

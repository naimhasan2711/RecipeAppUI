package com.alex.android.receipeappui

sealed class Screens(val route : String) {
    object Discover : Screens("discover_screen")
    object Search : Screens("search_screen")
    object MyRecipe : Screens("recipe_screen")
    object Settings : Screens("settings_screen")
}

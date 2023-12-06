package com.alex.android.receipeappui.bottomnavigation

import androidx.annotation.DrawableRes
import com.alex.android.receipeappui.R
import com.alex.android.receipeappui.Screens

data class BottomNavigationItem(
    val label : String = "",
    @DrawableRes
    val icon : Int = R.drawable.discovery,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Discover",
                icon = R.drawable.discovery,
                route = Screens.Discover.route
            ),
            BottomNavigationItem(
                label = "Search",
                icon = R.drawable.search,
                route = Screens.Search.route
            ),
            BottomNavigationItem(
                label = "My Recipes",
                icon = R.drawable.book,
                route = Screens.MyRecipe.route
            ),
        )
    }
}
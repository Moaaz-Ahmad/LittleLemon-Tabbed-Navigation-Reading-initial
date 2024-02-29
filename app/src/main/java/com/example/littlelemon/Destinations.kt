package com.example.littlelemon

interface Destinations{
    val route: String
    val title: String
    val icon: Int
    object Home: Destinations{
        override val route = "home"
        override val title = "Home"
        override val icon = R.drawable.ic_home
    }
    object Menu: Destinations{
        override val route = "menu"
        override val title = "Menu"
        override val icon = R.drawable.ic_menu
    }
    object Location: Destinations{
        override val route = "location"
        override val title = "Location"
        override val icon = R.drawable.ic_location
    }
}

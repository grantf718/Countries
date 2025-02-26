package edu.quinnipiac.ser210.countries.Navigation

import java.lang.IllegalArgumentException

enum class Screen {
    CountryListScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route: String?): Screen
            = when (route?.substringBefore("/")){
                CountryListScreen.name -> CountryListScreen
                DetailsScreen.name -> DetailsScreen
                null -> DetailsScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}
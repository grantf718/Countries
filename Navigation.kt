package edu.quinnipiac.ser210.countries.Navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.quinnipiac.ser210.countries.screens.CountryListScreen
import edu.quinnipiac.ser210.countries.screens.DetailsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(){

    val navController = rememberNavController()
    val canNavigateBack = navController.currentBackStackEntry != null

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        // Top App Bar
        topBar = {
            CountriesAppBar(
                currentScreen = "Countries App",
                canNavigateBack = true, //navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                modifier = Modifier
            )
        }
    )
    { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.CountryListScreen.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            composable(Screen.CountryListScreen.name){
                CountryListScreen(navController = navController)
            }

            composable(
                Screen.DetailsScreen.name+"/{country}",
                arguments = listOf(navArgument(name = "country") { type = NavType.StringType }))
            { backStackEntry ->
                DetailsScreen(
                    navController = navController,
                    backStackEntry.arguments?.getString("country")
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesAppBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier,
    ){
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        // Title text
        title = {
            Text("Countries")
        },
        // Back button
        navigationIcon = {
            IconButton(onClick = navigateUp){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go back"
                )
            }
        }
    )
}
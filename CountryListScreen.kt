package edu.quinnipiac.ser210.countries.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.countries.model.Country
import edu.quinnipiac.ser210.countries.model.CountryList
import edu.quinnipiac.ser210.countries.Navigation.Screen

@Composable
fun CountryListScreen(navController: NavController) {
    MainContent(navController = navController)
}

@Composable
fun MainContent(
    navController: NavController,
    countryList: List<Country> = CountryList
    )
{
    LazyColumn{
        items(items = countryList) {
            CountryRow(country = it){ country ->
                navController.navigate(route = Screen.DetailsScreen.name+"/$country")
            }
        }
    }

}


// Row of a specific country
@Composable
fun CountryRow(country: Country = CountryList[0], onItemClick: (String) -> Unit = {} ){
    Row(
        modifier = Modifier
            .clickable { onItemClick(country.name) }
            .padding(16.dp)
    ){
        // Flag
        Image(
            painter = painterResource(id = country.flag),
            contentDescription = null,
            modifier = Modifier
                .padding(15.dp)
                .weight(1f) // space given in row
                .offset(0.dp, (-25).dp)
                .aspectRatio(1f) // size (proportional)
        )
        // Text
        Column(modifier = Modifier.weight(2f)){
            Spacer(modifier = Modifier.size(15.dp))
            // Name
            Text(text = country.name, fontSize = 28.sp)
            // Currency
            Text(text = country.currency, fontSize = 20.sp)
        }
    }
}
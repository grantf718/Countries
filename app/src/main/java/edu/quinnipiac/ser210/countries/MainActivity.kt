package edu.quinnipiac.ser210.countries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.quinnipiac.ser210.countries.ui.theme.CountriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountriesTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    CountryListScreen()
                }
            }
        }
    }
}

// Lazy column of countries
@Composable
fun CountryListScreen(){
    LazyColumn(){
        items(CountryList) { country ->
            CountryRow(country)
        }
    }
}

// Row of a specific country
@Composable
fun CountryRow(country: Country){
    Row{
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
            // Name
            Text(text = country.name, fontSize = 35.sp)
            // Currency
            Text(text = country.currency, fontSize = 28.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview(){
    CountryListScreen()
}
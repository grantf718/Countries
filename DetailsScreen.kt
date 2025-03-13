package edu.quinnipiac.ser210.countries.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.countries.model.CountryList

@Composable
fun DetailsScreen(navController: NavController, countryName: String?) {
    val countryList = CountryList.filter { country ->
        country.name == countryName
    }
    // Information
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text( buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Black, fontSize = 24.sp)
            ) {
                append("Fun Fact: ")
            }
            withStyle(style = SpanStyle(color = Color.Black, fontSize = 20.sp)
            ) {
                append(countryList[0].fact)
            }

        }, modifier = Modifier.padding(6.dp))

        HorizontalDivider(modifier = Modifier.padding(3.dp))

        Text(text = "Map of ${countryList[0].name}:", style = MaterialTheme.typography.titleLarge)

        Image(
            painter = painterResource(id = countryList[0].map),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )

    }

}

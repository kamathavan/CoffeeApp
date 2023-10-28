@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.lbgtest.coffee.presentations.coffeedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.lbgtest.coffee.presentations.coffeelist.IngredientChip
import coil.compose.rememberImagePainter
import com.app.lbgtest.coffee.presentations.AppBar
import com.app.lbgtest.coffeedomain.model.Coffee

@OptIn(ExperimentalMaterial3Api::class)
@Composable()
fun CoffeeDetailsScreen(coffee: Coffee?) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                AppBar(title = "Coffee Details")
            },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxSize()
                            .padding(18.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        val painter = rememberImagePainter(data = coffee?.image)

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = coffee?.title ?: "",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start
                            )
                        }

                        Image(
                            painter = painter,
                            contentDescription = "Coffee Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(320.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                        )

                        CoffeeContentTitle(contentTitle = "Descriptions:")

                        Text(text = coffee?.description ?: "", textAlign = TextAlign.Justify)

                        CoffeeContentTitle(contentTitle = "Ingredients:")

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(
                                4.dp,
                                alignment = Alignment.Start
                            ),
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            items(items = coffee?.ingredients ?: listOf()) { ingredient ->
                                IngredientChip(text = ingredient)
                            }
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun CoffeeContentTitle(contentTitle: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = contentTitle,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
    }

}



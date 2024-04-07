package com.ifood.deliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.ifood.deliveryapp.ui.theme.DeliveryAppTheme

class RestaurantListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = RestaurantListViewModel()

        super.onCreate(savedInstanceState)
        setContent {
            DeliveryAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    RestaurantList(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun RestaurantList(viewModel: RestaurantListViewModel) {

    LaunchedEffect(Unit, block = {
        viewModel.getRestaurantList()
    })

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Restaurant List",
            modifier = Modifier.padding(10.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
            ), fontWeight = FontWeight.Black
        )

        LazyColumn {

            items(viewModel.restaurantList) { restaurant ->
                Text(restaurant.name, modifier = Modifier.padding(15.dp))
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantListPreview() {
    DeliveryAppTheme {
        RestaurantList(viewModel = RestaurantListViewModel())
    }
}
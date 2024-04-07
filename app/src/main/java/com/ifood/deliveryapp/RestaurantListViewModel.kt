package com.ifood.deliveryapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RestaurantListViewModel: ViewModel() {
    private val _restaurantList = mutableStateListOf<Restaurant>()
    val restaurantList: List<Restaurant>
        get() = _restaurantList

    suspend fun getRestaurantList() {
        viewModelScope.launch {
            val apiService = APIClient().getAPIService()
            try {
                _restaurantList.clear()
                _restaurantList.addAll(apiService.getRestaurantList())
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}
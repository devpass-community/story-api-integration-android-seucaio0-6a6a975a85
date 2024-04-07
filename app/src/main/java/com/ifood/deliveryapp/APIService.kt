package com.ifood.deliveryapp

import retrofit2.http.GET

const val RESTAURANT_LIST_ENDPOINT = "home_restaurant_list.json"

interface APIService {

    @GET(RESTAURANT_LIST_ENDPOINT)
    suspend fun getRestaurantList(): List<Restaurant>

}
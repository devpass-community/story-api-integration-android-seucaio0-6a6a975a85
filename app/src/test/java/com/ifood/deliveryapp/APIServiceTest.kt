package com.ifood.deliveryapp

import org.junit.Assert.assertNotNull
import org.junit.Test

class APIServiceTest {

    @Test
    fun testAPIService() {

        val apiService = APIClient().getAPIService()
        assertNotNull(apiService)
    }
}

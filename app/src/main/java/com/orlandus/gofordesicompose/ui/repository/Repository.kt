package com.orlandus.gofordesicompose.ui.repository

import com.orlandus.gofordesicompose.ui.models.Tabs
import retrofit2.Response

class Repository() {

    suspend fun getBottomTabs(): Response<Tabs> {

        return RetrofitInstance.api.getBottomTabs()

    }

}
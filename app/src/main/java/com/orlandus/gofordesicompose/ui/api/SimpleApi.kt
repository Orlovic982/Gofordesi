

import com.orlandus.gofordesicompose.ui.models.Tabs
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @GET("/mobile-settings")
    suspend fun getBottomTabs(
    ): Response<Tabs>

}


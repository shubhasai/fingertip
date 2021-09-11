package `in`.vikins.fingertip.homescreen.network

import `in`.vikins.fingertip.homescreen.models.Recyclerlist
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("top-headlines/category/general/in.json")
    suspend fun getDataFromApi(@Query("q") query :String): Recyclerlist
}
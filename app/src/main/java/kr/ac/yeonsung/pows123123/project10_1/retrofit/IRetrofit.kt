package kr.ac.yeonsung.pows123123.project10_1.retrofit

import android.telecom.Call
import com.google.gson.JsonElement
import kr.ac.yeonsung.pows123123.project10_1.utils.API
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {
    //https://www.unsplash.com/search/search/photos/?query=""
    @GET(API.SEARCH_PHOTOS)
    fun searchPhotos(@Query("query") searchTerm:String) : retrofit2.Call<JsonElement>

    @GET(API.SEARCH_USERS)
    fun searchUsers(@Query("query") searchTerm:String) : retrofit2.Call<JsonElement>

}
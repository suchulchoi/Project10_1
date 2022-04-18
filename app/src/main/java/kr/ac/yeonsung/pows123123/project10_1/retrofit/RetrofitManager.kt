package kr.ac.yeonsung.pows123123.project10_1.retrofit

import android.util.Log
import com.google.gson.JsonElement
import kr.ac.yeonsung.pows123123.project10_1.utils.API
import retrofit2.Retrofit
import retrofit2.create
import kr.ac.yeonsung.pows123123.project10_1.retrofit.IRetrofit
import kr.ac.yeonsung.pows123123.project10_1.utils.Constants.TAG
import retrofit2.Call
import retrofit2.Response


class RetrofitManager {

    companion object{
        val instance = RetrofitManager()
    }
    //http 콜 만들기
    //레트로핏 인터페이스 가져오기
    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    //사진 검색 api 호출
    fun searchPhotos(searchTerm: String? , completion: (String) -> Unit){
        val term = searchTerm.let {
            it
        }?:""
        //val term = searchTerm ?: ""

//        val  call = iRetrofit?.searchPhotos(searchTerm = term).let {
//            it
//        }?: return

        val  call = iRetrofit?.searchPhotos(searchTerm = term).let {
            it
        }?: return
//        val  call = iRetrofit?.searchPhotos(searchTerm = term) ?: return
        call.enqueue(object : retrofit2.Callback<JsonElement> {
            //응답 실패시
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / t: $t")
            }
            //응답 성공시
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - onFailure() called / response : ${response.raw()}")
                completion(response.raw().toString())
            }
        })
    }
}
package kr.ac.yeonsung.pows123123.project10_1.retrofit

import android.content.ContentValues.TAG
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Tag
import retrofit2.http.Url
import kotlin.math.log

//싱글턴 메모리 하나 만 씀
object RetrofitClient {
    //레트로핏 클라이언트 선언
    private var retrofitClient : Retrofit? = null
    //private lateinit var retrofitClient : Retrofit
    //레프로핏 클라이언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "RetrofitClient - getClient() called")
        if(retrofitClient == null){
            //레트로핏 빌더를 통해 인스턴스 생성
            retrofitClient = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return  retrofitClient
    }

}
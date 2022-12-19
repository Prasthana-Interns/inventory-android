package com.example.inventory

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var apiService: ApiService

    fun getApiService(context: Context): ApiService {

        // Initialize ApiService if not initialized yet
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                 .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient(context))
                .build()
            apiService = retrofit.create(ApiService::class.java)
        }

        return apiService
    }
    private fun okhttpClient(context: Context): OkHttpClient {
       return OkHttpClient.Builder()
           .addInterceptor(OAuthInterceptor(context))
               .build()




    }
}
//class ApiClient {
//    private lateinit var apiService: ApiService
//
//    fun getApiService(context: Context): ApiService {
//
//        // Initialize ApiService if not initialized yet
//        if (!::apiService.isInitialized) {
//            val retrofit = Retrofit.Builder()
//            ...

//
//        return apiService
//    }
//
//    /**
//     * Initialize OkhttpClient with our interceptor
//     */
//    private fun okhttpClient(context: Context): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(AuthInterceptor(context))
//            .build()
//    }
//
//}
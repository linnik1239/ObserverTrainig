package com.example.practice21observer.data.network

import com.example.practice21observer.models.PostResponse
import com.google.gson.JsonElement
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi2{

  @GET("posts")
  fun getPosts(): Single<PostResponse>


    companion object{
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        operator fun invoke(): MyApi2{
//            return Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(MyApi2::class.java)


            return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(MyApi2::class.java)

//
//            return Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addCallAdapterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .build()
//                    .create(MyApi2::class.java)
        }
    }



}
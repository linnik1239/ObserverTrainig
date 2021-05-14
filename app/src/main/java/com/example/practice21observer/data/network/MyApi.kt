package com.example.practice21observer.data.network

import com.example.practice20mvvm.models.UserR
import com.google.gson.JsonElement
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi{

    @GET("users")
    fun casllUser(
    //    @Body user: UserR
//        @Field("email") email: String,
//        @Field("password") password: String,
    )
            : Call<JsonElement>



    companion object{
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        operator fun invoke(): MyApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }




}
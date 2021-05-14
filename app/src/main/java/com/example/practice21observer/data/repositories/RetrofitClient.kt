package com.example.practice21observer.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practice21observer.data.network.MyApi
import com.google.gson.JsonElement
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitClient {
    fun userAccess() : LiveData<String> {
        var userResponse = MutableLiveData<String>()
        var api = MyApi()


        api.casllUser()
            .enqueue(object: Callback<JsonElement> {
                override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                    var jsonElement:JsonElement? =  response.body()

                    userResponse.value = response.headers().toString()
                    Log.d("abc","success "+jsonElement.toString())
                    Log.d("abc","success "+response.isSuccessful.toString())
              }

                override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                    TODO("Not yet implemented")
                }
//                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//
//                    userResponse.value = response.headers().toString()
//                    Log.d("abc","success "+response.body().toString())
//                    Log.d("abc","success "+response.isSuccessful.toString())
//                    Log.d("abc","success "+response.headers().toString())
//                    Log.d("abc","success "+response.headers().names().toString())
//                    Log.d("abc","success "+response.headers().get("users").toString())
//
//                }
//
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    TODO("Not yet implemented")
//                    userResponse.value = t.message.toString()
//                    Log.d("abc",t.message.toString())
//
//
//                }

            }





            )

        return userResponse



    }
}
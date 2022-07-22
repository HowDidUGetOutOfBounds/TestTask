package by.sergey.network

import by.sergey.data.Root
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET(".")
    fun getBitcoinInfo(): Call<Root>
}


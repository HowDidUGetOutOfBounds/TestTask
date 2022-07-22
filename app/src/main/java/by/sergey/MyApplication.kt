package by.sergey

import android.app.Application
import by.sergey.network.ApiInterface
import by.sergey.network.BitcoinNetworkDataImpl
import by.sergey.ui.MainActivityViewModel
import by.sergey.util.Utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyApplication:Application(){
    override fun onCreate() {
        super.onCreate()
    }

    companion object{
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service: ApiInterface = retrofit.create(ApiInterface::class.java)
        val repo = BitcoinNetworkDataImpl(service)

        val viewmodel: MainActivityViewModel = MainActivityViewModel(repo)
    }
}
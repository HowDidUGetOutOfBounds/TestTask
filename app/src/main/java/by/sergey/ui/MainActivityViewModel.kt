package by.sergey.ui

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.sergey.data.Root
import by.sergey.network.BitcoinNetworkDataImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(val networkRepo: BitcoinNetworkDataImpl) : ViewModel() {
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val data: MutableLiveData<Root?> = MutableLiveData(null)

    fun getBitcoinData() {
        viewModelScope.launch {
            isLoading.postValue(true)
            withContext(Dispatchers.IO) {
                data.postValue(networkRepo.getBitcoinData())
                isLoading.postValue(false)
            }
        }

    }

    fun subscribeToBitcoinData() {
        val mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {
                getBitcoinData()
                mainHandler.postDelayed(this, 60000)
            }
        })
    }
}
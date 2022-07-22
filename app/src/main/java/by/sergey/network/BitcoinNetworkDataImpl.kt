package by.sergey.network

import by.sergey.data.Root

class BitcoinNetworkDataImpl(private val api: ApiInterface) : BitcoinNetworkData {
    override fun getBitcoinData(): Root? {
        return api.getBitcoinInfo().execute().body()
    }

}
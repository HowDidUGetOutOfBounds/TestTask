package by.sergey.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.sergey.MyApplication
import by.sergey.tobiastask.R
import by.sergey.tobiastask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val vm = MyApplication.viewmodel
        vm.subscribeToBitcoinData()

        adapter = MyRecyclerViewAdapter()
        binding.bitcoinRates.layoutManager = LinearLayoutManager(this)
        binding.bitcoinRates.adapter = adapter

        vm.isLoading.observe(this){
            if(it) {
                binding.progress.visibility = View.VISIBLE
                binding.bitcoinRates.visibility = View.INVISIBLE
            }
            else
            {
                binding.progress.visibility = View.INVISIBLE
                binding.bitcoinRates.visibility = View.VISIBLE
            }
        }

        vm.data.observe(this){
            if(it != null) {
                 adapter.addItem(it)
            }
        }
    }
}
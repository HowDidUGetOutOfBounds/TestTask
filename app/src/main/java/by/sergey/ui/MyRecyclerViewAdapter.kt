package by.sergey.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.sergey.data.Root
import by.sergey.tobiastask.databinding.BitcoinListItemBinding

class MyRecyclerViewAdapter(val list: ArrayList<Root> = ArrayList()) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: BitcoinListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = BitcoinListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        with(holder.binding)
        {
            timestamp.text = currentItem.time?.updated
            price.text = currentItem.bpi?.EUR?.rate_float.toString()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItem(item: Root?)
    {
        if(item!=null)
        {
            if(list.size >50)
            {
                list.removeAt(0)
            }
            list.add(item)
        }
        notifyDataSetChanged()
    }
}
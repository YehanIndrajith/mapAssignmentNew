package com.example.mobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile.mapData.Location
import com.example.mobile.R

class DataAdapter(private var items: List<Location>, private val communicator: View) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val itemTitle: TextView = itemView.findViewById(R.id.text_name)

            //val itemTitle: TextView = itemView.findViewById(R.id.tv_name)

        init {


            itemView.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
            val currentItem = items[adapterPosition]
            val bundle = bundleOf("location" to currentItem)
            communicator.findNavController().navigate(R.id.mapsFragment, bundle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemTitle.text = items[position].name
        //holder.itemTile
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

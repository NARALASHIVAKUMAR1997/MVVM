package com.example.roomwithexoplayer.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomwithexoplayer.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.child_layout_for_home_screen.view.*

class RecyclerViewAdapter(private var list: List<String>,
                          private var clickListener: (view: View, position: Int) -> Unit) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.child_layout_for_home_screen, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        Picasso.with(holder.itemView.context).load(list[position]).into(holder.imageButton)
        holder.itemView.images.setOnClickListener {
            clickListener(it,position)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageButton = itemView.images
    }

    fun updateData(mutableList: List<String>){
        this.list = mutableList
        notifyDataSetChanged()
    }
}
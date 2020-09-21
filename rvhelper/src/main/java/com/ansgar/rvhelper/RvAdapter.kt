package com.ansgar.rvhelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class RvAdapter(private val rvAdapterHelper: RvAdapterBuilder) : RecyclerView.Adapter<BaseViewHolder>() {
    val items = ArrayList<ViewHolderItem>()

    override fun getItemViewType(position: Int): Int = items[position].layoutRes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return rvAdapterHelper.getOnVhCreatedListener(viewType).invoke(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}
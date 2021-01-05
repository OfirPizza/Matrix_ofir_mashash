package com.test.matrix_ofir_mashash.ui.mainScreen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.matrix_ofir_mashash.R
import com.test.matrix_ofir_mashash.network.model.DataItemObject
import com.test.matrix_ofir_mashash.ui.mainScreen.adapter.CatChildItemAdapter.CatChildViewHolder
import com.test.matrix_ofir_mashash.ui.model.CatChildItem
import kotlinx.android.synthetic.main.view_cat_child_item.view.*

class CatChildItemAdapter : RecyclerView.Adapter<CatChildViewHolder>() {

    private var data: List<CatChildItem> = listOf()
    var onSelectedItem: ((DataItemObject) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CatChildViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_cat_child_item, viewGroup, false)
        return CatChildViewHolder(view)
    }

    override fun onBindViewHolder(childViewHolder: CatChildViewHolder, position: Int) {
        childViewHolder.bind(data[position].childData)
    }

    override fun getItemCount(): Int = data.size

    fun updateData(newData: List<CatChildItem>) {
        data = newData
    }

    inner class CatChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(childData: DataItemObject) {
            itemView.child_item_title.text = childData.title
            itemView.child_item_sub_title.text = childData.subTitle
            Glide.with(itemView).load(childData.imageUrl)
                .placeholder(itemView.resources.getDrawable(R.drawable.ic_launcher_background))
                .into(itemView.img_child_item)
            itemView.setOnClickListener {
                onSelectedItem?.invoke(childData)
            }
        }
    }
}
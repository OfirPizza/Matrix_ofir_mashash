package com.test.matrix_ofir_mashash.ui.mainScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.matrix_ofir_mashash.R
import com.test.matrix_ofir_mashash.ui.mainScreen.ChildItemAdapter.ChildViewHolder
import com.test.matrix_ofir_mashash.ui.model.ChildItem
import com.test.matrix_ofir_mashash.ui.model.DataItemObject
import kotlinx.android.synthetic.main.child_item.view.*

class ChildItemAdapter internal constructor(private val ChildItemList: List<ChildItem>) :
    RecyclerView.Adapter<ChildViewHolder>() {
    var onSelectedItem: ((DataItemObject) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ChildViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.child_item, viewGroup, false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(childViewHolder: ChildViewHolder, position: Int) {
        val childItem = ChildItemList[position]
        childViewHolder.bind(childItem.childData)
    }

    override fun getItemCount(): Int { return ChildItemList.size }

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(childData: DataItemObject) {
            itemView.child_item_title.text = childData.Title
            itemView.child_item_sub_title.text = childData.STitle
            Glide.with(itemView).load(childData.Imag).placeholder(itemView.resources.getDrawable(R.drawable.ic_launcher_background)).into(itemView.img_child_item)
            itemView.setOnClickListener {
                onSelectedItem?.invoke(childData)
            }
        }
    }
}
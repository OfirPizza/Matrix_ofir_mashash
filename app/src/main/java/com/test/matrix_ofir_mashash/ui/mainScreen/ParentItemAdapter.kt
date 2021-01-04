package com.test.matrix_ofir_mashash.ui.mainScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.test.matrix_ofir_mashash.R
import com.test.matrix_ofir_mashash.ui.mainScreen.ParentItemAdapter.ParentViewHolder
import com.test.matrix_ofir_mashash.ui.model.DataItemObject
import com.test.matrix_ofir_mashash.ui.model.ParentItem
import kotlinx.android.synthetic.main.main_list_item.view.parent_item_title
import kotlinx.android.synthetic.main.parent_item.view.*

class ParentItemAdapter internal constructor(private val itemList: List<ParentItem>) :
    RecyclerView.Adapter<ParentViewHolder>() {
    private val viewPool = RecycledViewPool()
    var onItemClick : ((DataItemObject) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ParentViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.parent_item, viewGroup, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(parentViewHolder: ParentViewHolder, position: Int) {
        val parentItem = itemList[position]
        parentViewHolder.bind(parentItem)
    }

    override fun getItemCount(): Int { return itemList.size }

    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(parentItem: ParentItem) {
            itemView.parent_item_title.text = parentItem.parentItemTitle
            itemView.child_recyclerview.adapter =  ChildItemAdapter(parentItem.childItemList).apply {
                onSelectedItem = { this@ParentViewHolder.onSelectedItem(it) }
            }
            itemView.child_recyclerview.setRecycledViewPool(viewPool)

        }

        private fun onSelectedItem(itemObject: DataItemObject) {
            onItemClick?.invoke(itemObject)
        }
    }
}
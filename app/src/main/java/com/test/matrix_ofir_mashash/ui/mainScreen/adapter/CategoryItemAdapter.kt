package com.test.matrix_ofir_mashash.ui.mainScreen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.matrix_ofir_mashash.R
import com.test.matrix_ofir_mashash.network.model.DataItemObject
import com.test.matrix_ofir_mashash.ui.mainScreen.adapter.CategoryItemAdapter.CategoryViewHolder
import com.test.matrix_ofir_mashash.ui.model.CatChildItem
import com.test.matrix_ofir_mashash.ui.model.CategoryItem
import com.test.matrix_ofir_mashash.util.SnapHelper
import kotlinx.android.synthetic.main.view_category_item.view.*

class CategoryItemAdapter : RecyclerView.Adapter<CategoryViewHolder>() {
    private var data: List<CategoryItem> = listOf()
    private var useSnapHelper = false
    var onItemClick: ((DataItemObject) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CategoryViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_category_item, viewGroup, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(catViewHolder: CategoryViewHolder, position: Int) {
        catViewHolder.bind(data[position])

    }

    override fun getItemCount(): Int = data.size

    fun updateData(newData: List<CategoryItem>) {
        data = newData
    }

    fun updateSnapHelper(needSnapHelper: Boolean) {
        useSnapHelper = needSnapHelper
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var snapHelper = SnapHelper()

        fun bind(parentItem: CategoryItem) {
            setTitle(parentItem.catItemTitle)
            setCategoryItems(parentItem.catChildItemList)
            setSnapHelper()
        }

        private fun setSnapHelper() {
            snapHelper.attachToRecyclerView(null)
            if (useSnapHelper) {
                snapHelper.attachToRecyclerView(itemView.category_child_recyclerview)
            }
        }

        private fun setCategoryItems(itemList: List<CatChildItem>) {
            itemView.category_child_recyclerview.adapter = CatChildItemAdapter().apply {
                onSelectedItem = { this@CategoryViewHolder.onSelectedItem(it) }
                updateData(itemList)
            }
        }

        private fun setTitle(title: String) {
            itemView.category_item_title.text = title
        }

        private fun onSelectedItem(itemObject: DataItemObject) {
            onItemClick?.invoke(itemObject)
        }
    }
}
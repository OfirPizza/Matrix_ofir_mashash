package com.test.matrix_ofir_mashash.ui.selectedItem

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.test.matrix_ofir_mashash.R
import com.test.matrix_ofir_mashash.network.model.DataItemObject
import kotlinx.android.synthetic.main.fragment_item_selected.*


class SelectedItemFragment(private val item: DataItemObject) :
    Fragment(R.layout.fragment_item_selected) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        loadImage(item.imageUrl)
        setCatId(item.catId)
        setId(item.id)

    }

    private fun setId(id: Long) {
        selected_id.text = id.toString()
    }

    private fun setCatId(catId: Int) {
        selected_cat_id.text = catId.toString()
    }

    private fun loadImage(imag: String) {
        Glide.with(this).load(imag)
            .placeholder(resources.getDrawable(R.drawable.ic_launcher_background))
            .into(selected_img)
    }
}
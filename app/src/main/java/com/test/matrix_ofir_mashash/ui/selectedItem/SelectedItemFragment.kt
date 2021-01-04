package com.test.matrix_ofir_mashash.ui.selectedItem

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.test.matrix_ofir_mashash.R
import kotlinx.android.synthetic.main.fragment_item_selected.*


class SelectedItemFragment : Fragment(R.layout.fragment_item_selected) {

    private val args: SelectedItemFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        loadImage(args.selectedModel.Imag)
        setCatId(args.selectedModel.CatId)
        setId(args.selectedModel.Id)

    }

    private fun setId(id: Long) {
        selected_id.text = id.toString()
    }

    private fun setCatId(catId: Int) {
        selected_cat_id.text = catId.toString()
    }

    private fun loadImage(imag: String) {
        Glide.with(this).load(imag).placeholder(resources.getDrawable(R.drawable.ic_launcher_background)).into(selected_img)
    }


}
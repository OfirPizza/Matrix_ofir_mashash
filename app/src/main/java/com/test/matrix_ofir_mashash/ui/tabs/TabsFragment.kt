package com.test.matrix_ofir_mashash.ui.tabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.test.matrix_ofir_mashash.R
import kotlinx.android.synthetic.main.fragment_tabs.*


class TabsFragment : Fragment(R.layout.fragment_tabs), TabLayout.OnTabSelectedListener {
    var onRefreshList: ((Unit) -> Unit)? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        tab_layout.addOnTabSelectedListener(this)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        onRefreshList?.invoke(Unit)
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {}

    override fun onTabReselected(tab: TabLayout.Tab?) {}

}
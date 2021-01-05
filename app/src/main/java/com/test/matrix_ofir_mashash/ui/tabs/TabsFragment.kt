package com.test.matrix_ofir_mashash.ui.tabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.test.matrix_ofir_mashash.R
import kotlinx.android.synthetic.main.fragment_tabs.*


class TabsFragment : Fragment(R.layout.fragment_tabs), TabLayout.OnTabSelectedListener {
    var onOtherTabClick: ((Unit) -> Unit)? = null
    var onRecommendedClick: ((Unit) -> Unit)? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        tab_layout.addOnTabSelectedListener(this)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        if (tab?.text.toString() == resources.getString(R.string.reco_str)) {
            onRecommendedClick?.invoke(Unit)
            return
        }
        onOtherTabClick?.invoke(Unit)

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {}

    override fun onTabReselected(tab: TabLayout.Tab?) {}

}
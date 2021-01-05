package com.test.matrix_ofir_mashash.ui.mainScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.test.matrix_ofir_mashash.R
import com.test.matrix_ofir_mashash.network.model.DataItemObject
import com.test.matrix_ofir_mashash.ui.mainScreen.adapter.CategoryItemAdapter
import com.test.matrix_ofir_mashash.ui.model.CategoryItem
import com.test.matrix_ofir_mashash.ui.selectedItem.SelectedItemFragment
import com.test.matrix_ofir_mashash.ui.tabs.TabsFragment
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainFragmentViewModel by viewModel()

    private val adapter = CategoryItemAdapter().apply {
        onItemClick = { this@MainFragment.showItem(it) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        showTabFragment()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        main_recyclerview.adapter = adapter
    }

    private fun showTabFragment() {
        val fragment = TabsFragment().apply {
            onOtherTabClick = { this@MainFragment.onOtherTabClick() }
            onRecommendedClick = { this@MainFragment.onRecommended() }
        }
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.tab_fragment_container, fragment, fragment::class.java.simpleName)
            .commit()
    }

    private fun onOtherTabClick() {
        adapter.updateSnapHelper(false)
        onRefresh()
    }

    private fun onRecommended() {
        adapter.updateSnapHelper(true)
        onRefresh()
    }

    private fun onRefresh() {
        viewModel.getItemList()
    }

    private fun initViewModel() {
        viewModel.apply {
            dataLiveData.observe(viewLifecycleOwner, { updateAdapter(it) })
            getItemList()
        }
    }

    private fun updateAdapter(data: List<CategoryItem>) {
        adapter.updateData(data)
        adapter.notifyDataSetChanged()
    }

    private fun showItem(itemObject: DataItemObject) {
        requireActivity().supportFragmentManager.beginTransaction().replace(
            R.id.fragment_selected_container,
            SelectedItemFragment(itemObject),
            SelectedItemFragment::class.java.simpleName
        ).addToBackStack(SelectedItemFragment::class.java.simpleName).commit()
    }

}
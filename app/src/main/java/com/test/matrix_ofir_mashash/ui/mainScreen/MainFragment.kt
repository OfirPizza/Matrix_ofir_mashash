package com.test.matrix_ofir_mashash.ui.mainScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.test.matrix_ofir_mashash.R
import com.test.matrix_ofir_mashash.ui.model.DataItemObject
import com.test.matrix_ofir_mashash.ui.model.ParentItem
import com.test.matrix_ofir_mashash.ui.tabs.TabsFragment
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainFragmentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        showTabFragment()

    }

    private fun showTabFragment() {
        val fragment = TabsFragment().apply {
            onRefreshList = { this@MainFragment.onRefresh() }
        }
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, fragment::class.java.simpleName).commit()
    }

    private fun onRefresh() {
        viewModel.getItemList()
    }

    private fun initViewModel() {
        viewModel.apply {
            dataLiveData.observe(viewLifecycleOwner, Observer {
                updateAdapter(it)
            })
            getItemList()
        }
    }

    private fun updateAdapter(data: List<ParentItem>) {
        val adapter = ParentItemAdapter(data).apply {
            onItemClick = {this@MainFragment.showItem(it)}
        }
        parent_recyclerview.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private fun showItem(itemObject: DataItemObject) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToSelectedItemFragment(itemObject))
    }

}
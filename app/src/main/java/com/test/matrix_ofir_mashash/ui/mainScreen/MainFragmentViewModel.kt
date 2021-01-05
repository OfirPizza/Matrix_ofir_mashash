package com.test.matrix_ofir_mashash.ui.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.matrix_ofir_mashash.ui.mainScreen.repository.DataRepo
import com.test.matrix_ofir_mashash.ui.model.CategoryItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragmentViewModel(private val listRepo: DataRepo) : ViewModel() {

    private val dataMutableLiveData = MutableLiveData<List<CategoryItem>>()
    val dataLiveData: LiveData<List<CategoryItem>> = dataMutableLiveData


    fun getItemList() {
        CoroutineScope(Dispatchers.IO).launch { postDataList(listRepo.getDataList()) }
    }

    private fun postDataList(dataList: List<CategoryItem>) {
        dataMutableLiveData.postValue(dataList)
    }
}
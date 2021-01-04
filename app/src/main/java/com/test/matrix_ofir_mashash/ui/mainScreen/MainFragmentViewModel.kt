package com.test.matrix_ofir_mashash.ui.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.matrix_ofir_mashash.ui.model.ParentItem
import com.test.matrix_ofir_mashash.ui.repo.DataRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragmentViewModel(private val listRepo: DataRepo) : ViewModel() {

    private val dataMutableLiveData = MutableLiveData<List<ParentItem>>()
    val dataLiveData: LiveData<List<ParentItem>> = dataMutableLiveData

    fun getItemList() {
        CoroutineScope(Dispatchers.IO).launch { postDataList(listRepo.getDataList()) }
    }

    private fun postDataList(dataList: List<ParentItem>) {
        dataMutableLiveData.postValue(dataList)
    }
}
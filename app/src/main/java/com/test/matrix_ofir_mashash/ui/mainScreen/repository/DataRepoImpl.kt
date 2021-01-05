package com.test.matrix_ofir_mashash.ui.mainScreen.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.matrix_ofir_mashash.network.model.DataResponseObject
import com.test.matrix_ofir_mashash.ui.model.CatChildItem
import com.test.matrix_ofir_mashash.ui.model.CategoryItem
import com.test.matrix_ofir_mashash.util.getJsonDataFromAsset

class DataRepoImpl(private val context: Context) : DataRepo {

    override suspend fun getDataList(): List<CategoryItem> {
        val jsonString = getJsonDataFromAsset(context, "jsonObject.json")
        val listPersonType = object : TypeToken<DataResponseObject>() {}.type
        val response: DataResponseObject = Gson().fromJson(jsonString, listPersonType)
        return response.toUiModel()
    }


    private fun DataResponseObject.toUiModel(): List<CategoryItem> {
        val parentDataList = mutableListOf<CategoryItem>()
        dataObject.dataListCat.forEach { cat ->
            val childList = mutableListOf<CatChildItem>()
            dataObject.dataListObject.forEach {
                if (it.catId == cat.catId) {
                    childList.add(CatChildItem(it))
                }
            }
            parentDataList.add(CategoryItem(cat.catTitle, childList))
        }

        return parentDataList
    }
}
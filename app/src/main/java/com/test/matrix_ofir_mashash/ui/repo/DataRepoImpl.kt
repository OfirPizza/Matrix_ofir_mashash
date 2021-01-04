package com.test.matrix_ofir_mashash.ui.repo

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.matrix_ofir_mashash.ui.model.ChildItem
import com.test.matrix_ofir_mashash.ui.model.DataResponseObject
import com.test.matrix_ofir_mashash.ui.model.ParentItem
import com.test.matrix_ofir_mashash.util.getJsonDataFromAsset

class DataRepoImpl(private val context: Context) : DataRepo {

    override suspend fun getDataList(): List<ParentItem> {
        val jsonString = getJsonDataFromAsset(context, "jsonObject.json")
        val listPersonType = object : TypeToken<DataResponseObject>() {}.type
        val persons:DataResponseObject = Gson().fromJson(jsonString, listPersonType)
        return  persons.toUiModel()
    }


    fun DataResponseObject.toUiModel(): List<ParentItem> {
        var parentDatalist = mutableListOf<ParentItem>()
        DataObject.DataListCat.forEach {cat ->
            var childList = mutableListOf<ChildItem>()
            DataObject.DataListObject.forEach{
                if (it.CatId == cat.CatId){
                    childList.add(ChildItem(it))
                }
            }
            parentDatalist.add(ParentItem(cat.CTitle,childList))
        }

        return parentDatalist
    }
}
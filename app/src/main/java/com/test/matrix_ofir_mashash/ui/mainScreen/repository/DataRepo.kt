package com.test.matrix_ofir_mashash.ui.mainScreen.repository

import com.test.matrix_ofir_mashash.ui.model.CategoryItem

interface DataRepo {
    suspend fun getDataList(): List<CategoryItem>
}
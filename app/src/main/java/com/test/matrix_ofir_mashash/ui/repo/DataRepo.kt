package com.test.matrix_ofir_mashash.ui.repo

import com.test.matrix_ofir_mashash.ui.model.ParentItem

interface DataRepo {
suspend fun getDataList(): List<ParentItem>
}
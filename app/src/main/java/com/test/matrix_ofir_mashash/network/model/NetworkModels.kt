package com.test.matrix_ofir_mashash.network.model

import com.google.gson.annotations.SerializedName


data class DataResponseObject(
    @SerializedName("DataObject")
    val dataObject: DataListObject,
)


data class DataListObject(
    @SerializedName("DataListObject")
    val dataListObject: List<DataItemObject>,
    @SerializedName("DataListCat")
    val dataListCat: List<DataItemCat>
)


data class DataItemObject(
    @SerializedName("CatId")
    val catId: Int,
    @SerializedName("Title")
    val title: String,
    @SerializedName("STitle")
    val subTitle: String,
    @SerializedName("Imag")
    val imageUrl: String,
    @SerializedName("Id")
    val id: Long,
    @SerializedName("DataListAddr")
    val dataListAddr: List<AddressItemModel>
)

data class AddressItemModel(
    @SerializedName("Addr")
    val addr: String,
    @SerializedName("DAd")
    val dAd: String
)

data class DataItemCat(
    @SerializedName("CatId")
    val catId: Int,
    @SerializedName("CTitle")
    val catTitle: String
)

package com.test.matrix_ofir_mashash.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

    @Parcelize
    data class DataResponseObject(
        val DataObject: DataListObject,
    ) : Parcelable

    @Parcelize
    data class DataListObject(
        val DataListObject: List<DataItemObject>,
        val DataListCat: List<DataItemCat>
    ) : Parcelable

    @Parcelize
    data class DataItemObject(
        val CatId: Int,
        val Title: String,
        val STitle: String,
        val Imag: String,
        val Id: Long,
        val DataListAddr: List<AddressItemModel>
    ) : Parcelable

    @Parcelize
    data class AddressItemModel(
        val Addr: String,
        val DAd: String
    ) : Parcelable

    @Parcelize
    data class DataItemCat(
        val CatId: Int,
        val CTitle: String
    ) : Parcelable

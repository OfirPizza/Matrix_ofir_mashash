package com.test.matrix_ofir_mashash.ui.mainScreen.di

import com.test.matrix_ofir_mashash.ui.mainScreen.MainFragmentViewModel
import com.test.matrix_ofir_mashash.ui.mainScreen.repository.DataRepo
import com.test.matrix_ofir_mashash.ui.mainScreen.repository.DataRepoImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    factory<DataRepo> { DataRepoImpl(androidContext()) }
    viewModel { MainFragmentViewModel(get()) }
}
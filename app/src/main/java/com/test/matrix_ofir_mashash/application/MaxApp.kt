package com.test.matrix_ofir_mashash.application

import android.app.Application

@Suppress("unused")
class MaxApp : Application() {


    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() = KoinStarter().start(this)
}
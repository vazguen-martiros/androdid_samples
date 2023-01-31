package com.dev.vazguen.unittest

import android.util.Log

class Logger {
    companion object {
        private  const val TAG="Logger"
    }
    fun log(message: String){
        Log.d(TAG,message)
    }
}
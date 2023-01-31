package com.dev.vazguen.unittest

import android.nfc.Tag
import android.util.Log

class Tracker {
    companion object

    val TAG = "Tracker"
    fun sendMessage(message: Message) {
        Log.d(TAG, "texto: ${message.texto}, code: ${message.code}")
    }
    fun sendCode(code:Int){
        Log.d(TAG,"$code")
    }
}
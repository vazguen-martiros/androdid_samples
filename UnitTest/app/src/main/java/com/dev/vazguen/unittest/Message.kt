package com.dev.vazguen.unittest

data class Message
    (
    val texto:String,
    val code:Code
    )
{
        enum class Code{
            CODE_1,
            CODE_2
        }
}
package com.dev.vazguen.basiclibrary

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast

class BasicButton @JvmOverloads constructor(
    context:Context,
    attrs: AttributeSet,
    defStule:Int =0,
    defStyle:Int=0
):LinearLayout(context,attrs,defStule,defStyle){
    init {
        LayoutInflater.from(context).inflate(R.layout.component_btn_buttonbassic,this,true)
        val btn = findViewById<ImageButton>(R.id.btnBasicButton)
        btn.setOnClickListener{Toast.makeText(context,"Clicked !!",Toast.LENGTH_SHORT).show()}
    }
}

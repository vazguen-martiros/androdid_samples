package com.dev.vazguen.dibuja

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.dev.vazguen.dibuja.PaintView.Companion.colorList
import com.dev.vazguen.dibuja.PaintView.Companion.pathList

class MainActivity : AppCompatActivity() {
        @SuppressLint("WrongViewCast")
        companion object {
            var path = Path()
            var paintBrush = Paint()
        }
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val blueBtn = findViewById<ImageButton>(R.id.blueColor)
        val blackBtn = findViewById<ImageButton>(R.id.blackColor)
        val whiteBtn = findViewById<ImageButton>(R.id.whiteColor)
        val eraser = findViewById<Button>(R.id.eraser)

            redBtn.setOnClickListener{
            paintBrush.color=Color.RED
            currentColor(paintBrush.color)
        }
        blueBtn.setOnClickListener{
            paintBrush.color=Color.BLUE
            currentColor(paintBrush.color)
        }
        blackBtn.setOnClickListener{
            paintBrush.color=Color.BLACK
            currentColor(paintBrush.color)
        }
        whiteBtn.setOnClickListener{
            paintBrush.color=Color.WHITE
            currentColor(paintBrush.color)
        }
        eraser.setOnClickListener{
               pathList.clear()
               colorList.clear()
               path.reset()
           }
        }
    private  fun currentColor(color:Int){
        PaintView.currentBrush= color
        path = Path()
    }

}
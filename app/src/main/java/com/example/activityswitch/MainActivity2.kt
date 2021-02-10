package com.example.activityswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import android.widget.RelativeLayout
import com.example.minipaint.MyCanvasView
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myCanvasView = MyCanvasView(this)

        myCanvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)
        //setContentView(myCanvasView)
        setContentView(R.layout.activity_main2)

        val myView = MyCanvasView(this);
        drawingLayout.addView(myView);

        val btnClear = findViewById<Button>(R.id.button2)
        btnClear.setOnClickListener {
            val myView2 = MyCanvasView(this);
            drawingLayout.addView(myView2)
        }
    }
}
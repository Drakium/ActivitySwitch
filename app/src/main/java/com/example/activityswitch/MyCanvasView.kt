package com.example.minipaint

import android.content.Context
import android.graphics.*
import android.view.View
import androidx.core.content.res.ResourcesCompat
import android.view.MotionEvent
import android.view.ViewConfiguration
import com.example.activityswitch.R

private const val STROKE_WIDTH = 12f // has to be float
private const val STROKE_WIDTH_BIG = 30f
private const val STROKE_WIDTH_BIGGER = 50f

class MyCanvasView(context: Context) : View(context) {
    private var path = Path()
    private val drawColor = ResourcesCompat.getColor(resources, R.color.colorPaint, null)
    private val drawColor2 = ResourcesCompat.getColor(resources, R.color.colorOrange, null)
    private val drawColor3 = ResourcesCompat.getColor(resources, R.color.colorBlack, null)
    private val drawColor4 = ResourcesCompat.getColor(resources, R.color.colorRed, null)
    private val drawColor5 = ResourcesCompat.getColor(resources, R.color.colorBlue, null)
    private val drawColor6 = ResourcesCompat.getColor(resources, R.color.colorPurple, null)
    private val drawColor7 = ResourcesCompat.getColor(resources, R.color.colorGreen, null)
    private val drawColor8 = ResourcesCompat.getColor(resources, R.color.colorBrown, null)
    private val drawColor9 = ResourcesCompat.getColor(resources, R.color.colorEraser, null)
    private val drawColor10 = ResourcesCompat.getColor(resources, R.color.colorYellow, null)
    private val backgroundColor = ResourcesCompat.getColor(resources, R.color.colorBackground,
        null)
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f
    private var motionTouchEventBlackX = 0f
    private var motionTouchEventBlackY = 0f
    private var currentX = 0f
    private var currentY = 0f
    private var colorName = ""
    private var strokeSize = 12F
    private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop
    private lateinit var frame: Rect
    private fun touchStart() {
        path.reset()
        path.moveTo(motionTouchEventX, motionTouchEventY)
        currentX = motionTouchEventX
        currentY = motionTouchEventY
    }

    private fun touchMove(colorName: String, strokeSize: Float) {
        val dx = Math.abs(motionTouchEventX - currentX)
        val dy = Math.abs(motionTouchEventY - currentY)
        val testVal = 0
        if (dx >= touchTolerance || dy >= touchTolerance) {
            // QuadTo() adds a quadratic bezier from the last point,
            // approaching control point (x1,y1), and ending at (x2,y2).
            path.quadTo(currentX, currentY, (motionTouchEventX + currentX) / 2, (motionTouchEventY + currentY) / 2)
            currentX = motionTouchEventX
            currentY = motionTouchEventY
            if (colorName == "Orange"){
                paintOrange.strokeWidth = strokeSize
                extraCanvas.drawPath(path, paintOrange)
            }
            if (colorName == "Black"){
                paintBlack.strokeWidth = strokeSize
                extraCanvas.drawPath(path, paintBlack)
            }
            if (colorName == "Red"){
                paintRed.strokeWidth = strokeSize
                extraCanvas.drawPath(path, paintRed)
            }
            if (colorName == "Blue"){
                paintBlue.strokeWidth = strokeSize
                extraCanvas.drawPath(path, paintBlue)
            }
            if (colorName == "Purple"){
                paintPurple.strokeWidth = strokeSize
                extraCanvas.drawPath(path, paintPurple)
            }
            if (colorName == "Green"){
                paintGreen.strokeWidth = strokeSize
                extraCanvas.drawPath(path, paintGreen)
            }
            if (colorName == "Brown"){
                paintBrown.strokeWidth = strokeSize
                extraCanvas.drawPath(path, paintBrown)
            }
            if (colorName == "Yellow"){
                paintYellow.strokeWidth = strokeSize
                extraCanvas.drawPath(path, paintYellow)
            }
            if (colorName == "Eraser"){
                paintEraser.strokeWidth = strokeSize
                extraCanvas.drawPath(path, paintEraser)
            }
            // Draw the path in the extra bitmap to cache it.
            //val btnSwitch = findViewById<Button>(R.id.button)
            //btnSwitch.setOnClickListener {
            //    extraCanvas.drawPath(path, paint)
            //}
        }
        invalidate()
    }

    private fun touchUp() {
        // Reset the path so it doesn't get drawn again.
        path.reset()
    }

    private val paint = Paint().apply {
        color = drawColor
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }

    private val paintOrange = Paint().apply {
        color = drawColor2
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }
    private val paintBlack = Paint().apply {
        color = drawColor3
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }
    private val paintRed = Paint().apply {
        color = drawColor4
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }
    private val paintBlue = Paint().apply {
        color = drawColor5
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }
    private val paintPurple = Paint().apply {
        color = drawColor6
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }
    private val paintGreen = Paint().apply {
        color = drawColor7
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }
    private val paintBrown = Paint().apply {
        color = drawColor8
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }
    private val paintYellow = Paint().apply {
        color = drawColor10
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }
    private val paintEraser = Paint().apply {
        color = drawColor9
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        //strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        val drawArea = height/8
        extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)
        val inset = 40
        val bottomInset = 250
        frame = Rect(inset, inset, width - inset, height - bottomInset)
        println(width - inset)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val colorAmount = 10F
        val colorWidth = width.toFloat()/colorAmount
        val drawArea = height.toFloat()/40F
        drawCanvasColors()
        canvas.drawBitmap(extraBitmap, 0f, 0f, null)
        canvas.drawRect(frame, paint)
        drawCircleOutline(canvas, colorWidth)
        drawCircleColors(canvas, colorWidth, drawArea)
    }

    private fun drawCanvasColors() {
        paintEraser.strokeWidth = STROKE_WIDTH
        paintBlack.strokeWidth = STROKE_WIDTH
        paintOrange.strokeWidth = STROKE_WIDTH
        paintRed.strokeWidth = STROKE_WIDTH
        paintBlue.strokeWidth = STROKE_WIDTH
        paintPurple.strokeWidth = STROKE_WIDTH
        paintGreen.strokeWidth = STROKE_WIDTH
        paintBrown.strokeWidth = STROKE_WIDTH
        paintYellow.strokeWidth = STROKE_WIDTH
    }
    private fun drawCircleOutline(canvas: Canvas, colorWidth: Float) {
        canvas.drawCircle(colorWidth,height.toFloat() - 200F, 15.0F, paintBlack)
        canvas.drawCircle((colorWidth)*2,height.toFloat() - 200F, 15.0F, paintBlack)
        canvas.drawCircle((colorWidth)*3,height.toFloat() - 200F, 15.0F, paintBlack)
        canvas.drawCircle((colorWidth)*4,height.toFloat() - 200F, 15.0F, paintBlack)
        canvas.drawCircle((colorWidth)*5,height.toFloat() - 200F, 15.0F, paintBlack)
        canvas.drawCircle((colorWidth)*6,height.toFloat() - 200F, 15.0F, paintBlack)
        canvas.drawCircle((colorWidth)*7,height.toFloat() - 200F, 15.0F, paintBlack)
        canvas.drawCircle((colorWidth)*8,height.toFloat() - 200F, 15.0F, paintBlack)
        canvas.drawCircle((colorWidth)*9,height.toFloat() - 200F, 15.0F, paintBlack)
    }
    private fun drawCircleColors(canvas: Canvas, colorWidth: Float, drawArea: Float){
        canvas.drawCircle(colorWidth,height.toFloat() - 200F, 10.0F, paintEraser)
        canvas.drawCircle((colorWidth)*2,height.toFloat() - 200F, 10.0F, paintBlack)
        canvas.drawCircle((colorWidth)*3,height.toFloat() - 200F, 10.0F, paintOrange)
        canvas.drawCircle((colorWidth)*4,height.toFloat() - 200F, 10.0F, paintRed)
        canvas.drawCircle((colorWidth)*5,height.toFloat() - 200F, 10.0F, paintBlue)
        canvas.drawCircle((colorWidth)*6,height.toFloat() - 200F, 10.0F, paintPurple)
        canvas.drawCircle((colorWidth)*7,height.toFloat() - 200F, 10.0F, paintGreen)
        canvas.drawCircle((colorWidth)*8,height.toFloat() - 200F, 10.0F, paintBrown)
        canvas.drawCircle((colorWidth)*9,height.toFloat() - 200F, 10.0F, paintYellow)
        canvas.drawCircle((colorWidth)*2,height.toFloat() - 200F, 6.0F, paintBlack)
        canvas.drawCircle((colorWidth)*3,height.toFloat() - 200F, 6.0F, paintOrange)
        canvas.drawCircle((colorWidth)*4,height.toFloat() - 200F, 6.0F, paintRed)
        canvas.drawCircle((colorWidth)*5,height.toFloat() - 200F, 6.0F, paintBlue)
        canvas.drawCircle((colorWidth)*6,height.toFloat() - 200F, 6.0F, paintPurple)
        canvas.drawCircle((colorWidth)*7,height.toFloat() - 200F, 6.0F, paintGreen)
        canvas.drawCircle((colorWidth)*8,height.toFloat() - 200F, 6.0F, paintBrown)
        canvas.drawCircle((colorWidth)*9,height.toFloat() - 200F, 6.0F, paintYellow)
        canvas.drawRect((colorWidth)*3 - 7.5F, (drawArea*39), (colorWidth)*3 + 7.5F, (drawArea*39)- 15F, paintBlack)
        canvas.drawRect((colorWidth)*5 - 15F, (drawArea*39), (colorWidth)*5 + 15F, (drawArea*39)- 30F, paintBlack)
        canvas.drawRect((colorWidth)*7 - 25F, (drawArea*39), (colorWidth)*7 + 25F, (drawArea*39)- 50F, paintBlack)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y
        val colorAmount = 10F
        val colorLineX =  width.toFloat()/colorAmount
        val drawArea = height.toFloat()/40F
        val colorLineYTop = (height - 210F)
        val colorLineYBottom = (height - 190F)
        if (motionTouchEventX > colorLineX - 15F && motionTouchEventY > colorLineYTop && motionTouchEventX < colorLineX + 10F && motionTouchEventY < colorLineYBottom){
            println("Eraser")
            colorName = "Eraser"
        }
        if (motionTouchEventX > (colorLineX*2) - 15F && motionTouchEventY > colorLineYTop && motionTouchEventX < (colorLineX*2) + 15F && motionTouchEventY < colorLineYBottom){
            println("Black")
            colorName = "Black"
        }
        if (motionTouchEventX > (colorLineX*3) - 15F && motionTouchEventY > colorLineYTop && motionTouchEventX < (colorLineX*3) + 15F && motionTouchEventY < colorLineYBottom){
            println("Orange")
            colorName = "Orange"
        }
        if (motionTouchEventX > (colorLineX*4) - 15F && motionTouchEventY > colorLineYTop && motionTouchEventX < (colorLineX*4) + 15F && motionTouchEventY < colorLineYBottom){
            println("Red")
            colorName = "Red"
        }
        if (motionTouchEventX > (colorLineX*5) - 15F && motionTouchEventY > colorLineYTop && motionTouchEventX < (colorLineX*5) + 15F && motionTouchEventY < colorLineYBottom){
            println("Blue")
            colorName = "Blue"
        }
        if (motionTouchEventX > (colorLineX*6) - 15F && motionTouchEventY > colorLineYTop && motionTouchEventX < (colorLineX*6) + 15F && motionTouchEventY < colorLineYBottom){
            println("Purple")
            colorName = "Purple"
        }
        if (motionTouchEventX > (colorLineX*7) - 15F && motionTouchEventY > colorLineYTop && motionTouchEventX < (colorLineX*7) + 15F && motionTouchEventY < colorLineYBottom){
            println("Green")
            colorName = "Green"
        }
        if (motionTouchEventX > (colorLineX*8) - 15F && motionTouchEventY > colorLineYTop && motionTouchEventX < (colorLineX*8) + 15F && motionTouchEventY < colorLineYBottom){
            println("Brown")
            colorName = "Brown"
        }
        if (motionTouchEventX > (colorLineX*9) - 15F && motionTouchEventY > colorLineYTop && motionTouchEventX < (colorLineX*9) + 15F && motionTouchEventY < colorLineYBottom){
            println("Yellow")
            colorName = "Yellow"
        }
        if (motionTouchEventX > (colorLineX*3) - 7.5 && motionTouchEventY > (drawArea*39) - 15F && motionTouchEventX < (colorLineX*3) + 7.5F && motionTouchEventY < (drawArea*39)){
            println("Small Size")
            strokeSize = STROKE_WIDTH
        }
        if (motionTouchEventX > (colorLineX*5) - 15F && motionTouchEventY > (drawArea*39) - 30F && motionTouchEventX < (colorLineX*5) + 15F && motionTouchEventY < (drawArea*39)){
            println("Medium Size")
            strokeSize = STROKE_WIDTH_BIG
        }
        if (motionTouchEventX > (colorLineX*7) - 25F && motionTouchEventY > (drawArea*39) - 50F && motionTouchEventX < (colorLineX*7) + 25F && motionTouchEventY < (drawArea*39)){
            println("Large Size")
            strokeSize = STROKE_WIDTH_BIGGER
        }
        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove(colorName, strokeSize)
            MotionEvent.ACTION_UP -> touchUp()
        }
        return true
    }

}

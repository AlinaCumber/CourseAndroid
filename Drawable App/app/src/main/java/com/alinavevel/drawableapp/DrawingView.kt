package com.alinavevel.drawableapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class DrawingView(context : Context, attribute : AttributeSet) : View(context, attribute) {

    private var color = Color.BLACK
    private var mDrawPath : CustomPatch? = null
    private var mSizeBrush : Float = 0.toFloat()
    private var mDrawPaint : Paint? = null
    private var mCanvasPaint : Paint? = null
    private var mCanvasBitmap : Bitmap? = null
    private var canvas : Canvas? = null

    init {
        setUpVar()
    }





    private fun setUpVar(){
        mDrawPaint = Paint()
        mDrawPath = CustomPatch(color, mSizeBrush)
        mDrawPaint!!.color = color
        mDrawPaint!!.style = Paint.Style.STROKE
        mDrawPaint!!.strokeCap = Paint.Cap.ROUND
        mDrawPaint!!.strokeJoin = Paint.Join.ROUND
        mCanvasPaint = Paint(Paint.DITHER_FLAG)
        mSizeBrush = 20.toFloat()
    }



    internal inner class CustomPatch( var color : Int, var bruchTick : Float) : Path(){

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
    }


}
package com.alinavevel.drawableapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View

class DrawingView(context : Context, attribute : AttributeSet) : View(context, attribute) {

    private var color = Color.BLACK
    private var mDrawPath : CustomPatch? = null
    private var mSizeBrush : Float = 0.toFloat()
    private var mDrawPaint : Paint? = null
    private var mCanvasPaint : Paint? = null
    private var mCanvasBitmap : Bitmap? = null
    private var canvas : Canvas? = null
    private val mPaths = ArrayList<CustomPatch>() // ArrayList for Paths

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

    fun setColor(newColor: String) {
        color = Color.parseColor(newColor)
        mDrawPaint?.color = color
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawBitmap(mCanvasBitmap!!, 0f, 0f, mCanvasPaint)

        for (p in mPaths) {
            mDrawPaint?.strokeWidth = p.bruchTick
            mDrawPaint?.color = p.color
            canvas.drawPath(p, mDrawPaint!!)
        }

        if(!mDrawPath!!.isEmpty){
            mDrawPaint!!.strokeWidth = mDrawPath!!.bruchTick
            mDrawPaint!!.color = mDrawPath!!.color
            canvas.drawPath(mDrawPath!!, mDrawPaint!!)
        }
    }

    fun setSizeForBrush(newSize: Float) {
        mSizeBrush = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, newSize,
            resources.displayMetrics
        )
        mDrawPaint?.strokeWidth = mSizeBrush
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val touchX = event?.x
        val touchY = event?.y

        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                mDrawPath?.color = color
                mDrawPath?.bruchTick = mSizeBrush

                mDrawPath?.reset() // Clear any lines and curves from the path, making it empty.
                mDrawPath?.moveTo(
                    touchX!!,
                    touchY!!
                )
            }
            MotionEvent.ACTION_MOVE -> {
                if(touchX != null){
                    if(touchY != null){

                        mDrawPath!!.lineTo(touchX, touchY)
                    }
                }
            }

            MotionEvent.ACTION_UP -> {
                mPaths.add(mDrawPath!!)
                mDrawPath = CustomPatch(color, mSizeBrush)
            }
            else -> return false


        }
        invalidate()


        return true
    }



    internal inner class CustomPatch( var color : Int, var bruchTick : Float) : Path(){

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)

        canvas = Canvas(mCanvasBitmap!!)
    }


}
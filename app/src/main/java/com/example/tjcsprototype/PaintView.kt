package com.example.tjcsprototype

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.tjcsprototype.TJCP.Companion.brush
import com.example.tjcsprototype.TJCP.Companion.path

class PaintView : View{

    var params : ViewGroup.LayoutParams? = null

    companion object{
        var PathL = arrayListOf<Path>()
        var ColorL = ArrayList<Int>()
        var CurrBrush = Color.BLACK



    }

    constructor(context: Context) : this(context, null){
        init()


    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()

    }

    constructor(context: Context,attrs: AttributeSet?, defStyleAttr: Int) :
            super(context,attrs,defStyleAttr){
        init()




    }
    private fun init(){
        brush.isAntiAlias = true
        brush.color = CurrBrush
        brush.style = Paint.Style.STROKE
        brush.strokeJoin = Paint.Join.ROUND
        brush.strokeWidth = 4f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }


    override fun onTouchEvent(event : MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
                return true

            }
            MotionEvent.ACTION_MOVE ->{
                path.lineTo(x,y)
                PathL.add(path)
                ColorL.add(CurrBrush)
            }


            else -> return false

        }


        postInvalidate()        //informs non-ui threds of changes on the UI
        return false;

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (i in PathL.indices){
            brush.setColor(ColorL[i])
            canvas.drawPath(PathL[i], brush)
            invalidate() //informs non-ui threds of changes on the UI
        }
    }


}
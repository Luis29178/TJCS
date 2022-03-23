package com.example.tjcsprototype

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.set
import com.example.tjcsprototype.TJCP.Companion.brush
import com.example.tjcsprototype.TJCP.Companion.path


class PaintView : View {

    var cRadi = 0F
    var cordinates: Array<Float> = arrayOf(0F, 0F)
    var params: ViewGroup.LayoutParams? = null
    var ClearCheck = false

    companion object {
        var PathL = arrayListOf<Path>()
        var ColorL = ArrayList<Int>()
        var CurrBrush = Color.BLACK


    }

    constructor(context: Context) : this(context, null) {
        init()


    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init()

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init()


    }

    private fun init() {
        brush.isAntiAlias = true
        brush.color = CurrBrush
        brush.style = Paint.Style.STROKE
        brush.strokeJoin = Paint.Join.ROUND
        brush.strokeWidth = 4f

        params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        var XYcord = arrayOf(x, y)



        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                cordinates = XYcord
                cRadi = 25F



                return true

            }
            MotionEvent.ACTION_MOVE -> {


            }
            MotionEvent.ACTION_UP -> {
                ClearCheck = true;
                ResetPath() // replace with sequential delete with bitmap array to save states of the path beeing drawn to then reset it bit by bit will give smooth transition

            }
            else -> return false

        }


        postInvalidate()        //informs non-ui threds of changes on the UI
        return false;

    }

    private fun ResetPath() {
        /// use bitmapse to save previous states befor drawn then use them to switch back and forth to slowly delete the drawn line


        /// temp


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)




        if (ClearCheck) {
            Thread.sleep(2000)
            // var bitmapcelar = BitmapFactory.decodeResource(resources, R.drawable.custumsmapog)
            //canvas.drawColor(0, PorterDuff.Mode.CLEAR)
            //canvas.drawBitmap(bitmapcelar, 0F, 0F, brush)
            //canvas.setBitmap(bitmapcelar)
            cordinates = arrayOf(0F, 0F)

            canvas.drawCircle(cordinates[0], cordinates[1], 0F, brush)
            ClearCheck = false
            cRadi = 0F
            invalidate()

        } else {
            canvas.drawCircle(cordinates[0], cordinates[1], 25F, brush)
            invalidate()
        }


        //invalidate() //informs non-ui threds of changes on the UI


    }


}
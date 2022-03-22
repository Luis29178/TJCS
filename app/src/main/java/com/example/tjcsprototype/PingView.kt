package com.example.tjcsprototype

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.set


class PingView : View {
    var params: ViewGroup.LayoutParams? = null
    var pingDrawable: Drawable? = null

    var xpos = x
    var ypos = y


companion object{
    var trigger = 1

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

        params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )


    }


    override fun onTouchEvent(event: MotionEvent): Boolean {

        xpos = event.x
        ypos = event.y


        // val pingDrawable = resources.getDrawable(R.drawable.ping)


         //time now + x

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (trigger == null) {
                    trigger = (System.currentTimeMillis() + 2000).toInt()
                    return true
                }
                return true
            }

            MotionEvent.ACTION_UP -> {
                trigger = 1
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                trigger = 1
                return true

            }
            else -> return false

        }
        postInvalidate()
        return false

    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (trigger < System.currentTimeMillis() && trigger != 1) {
            var xoff = xpos.toInt() + (pingDrawable?.intrinsicWidth ?: return)
            var yoff = ypos.toInt() - (pingDrawable?.intrinsicHeight ?: return)

            pingDrawable!!.bounds.set(xpos.toInt(), ypos.toInt(), xoff.toInt(), yoff.toInt())


            pingDrawable!!.draw(canvas)

            invalidate() //informs non-ui threds of changes on the UI
        }

    }


}
package com.example.tjcsprototype

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.graphics.set


class PingView : View {

    val holdchecker = false

    val pingDrawable = BitmapFactory.decodeResource(resources, R.drawable.ping)

    var xpos = x
    var ypos = y


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


    }


    override fun onTouchEvent(event: MotionEvent): Boolean {

        xpos = event.x
        ypos = event.y
        var braker = false

        // val pingDrawable = resources.getDrawable(R.drawable.ping)


        val trigger = System.currentTimeMillis() + 1900 //time now + 1 seconds 900 mils

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (braker) {
                    return false
                }
                if (trigger < System.currentTimeMillis() && !braker)
                {
                    pingDrawable.set(xpos.toInt(), ypos.toInt(), resources.getColor(R.color.black))
                return true
                }
            }

            MotionEvent.ACTION_UP -> {
                braker = true
                return false
            }
            MotionEvent.ACTION_MOVE -> {
                braker = true
                return false
            }

        }

        return false
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val piing = resources.getDrawable(R.drawable.ping, null)
        piing.setBounds(0, 0, x.toInt(), y.toInt())
        piing.draw(canvas)
        invalidate() //informs non-ui threds of changes on the UI


    }


}
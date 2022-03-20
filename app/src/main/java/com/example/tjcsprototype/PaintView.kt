package com.example.tjcsprototype

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.example.tjcsprototype.TJCP.Companion.brush

class PaintView : View{

    var params : ViewGroup.LayoutParams? = null

    companion object{
        var PathL = arrayListOf<Path>()
        var ColorL = ArrayList<Int>()
        var CurrBrush = Color.BLACK



    }

    constructor(context: Context) : this(context, null){



    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){


    }

    constructor(context: Context,attrs: AttributeSet?, defStyleAttr: Int) :
            super(context,attrs,defStyleAttr){





    }
    private fun init(){
        brush.isAntiAlias = true
        brush.color = CurrBrush
        brush.style = Paint.Style.STROKE
        brush.strokeJoin = Paint.Join.ROUND
        brush.strokeWidth = 0f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}
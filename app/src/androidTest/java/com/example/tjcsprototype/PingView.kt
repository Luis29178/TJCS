package com.example.tjcsprototype

import android.content.Context
import android.util.AttributeSet
import android.view.View

class PingView : View {






    constructor(context: Context) : this(context, null){
        init()


    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context,attrs,defStyleAttr){
        init()




    }
    private fun init() {

    }
    }





}
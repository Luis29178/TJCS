package com.example.tjcsprototype

import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TJCP : AppCompatActivity() {



    companion object{
        var path = Path()
        var brush = Paint()
        var ping = R.drawable.ping;

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_pathing)



    }
}
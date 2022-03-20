package com.example.tjcsprototype

import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TJCP : AppCompatActivity() {

    val MainMap = findViewById(R.id.CostumsMap) as ImageView

    companion object{
        var path = Path()
        var brush = Paint()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_pathing)



    }
}
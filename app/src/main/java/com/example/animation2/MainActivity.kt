package com.example.animation2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animation.GlobalFun
import com.example.animation2.shop.ShopActivity

class MainActivity : AppCompatActivity() {

    private lateinit var titleTV:TextView
    private lateinit var imgIV:ImageView
    private lateinit var startBTN:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        startBTN.setOnClickListener{
            startActivity(Intent(this@MainActivity, ShopActivity::class.java))
        }

        imgIV.startAnimation(GlobalFun().getAnimation(this@MainActivity,R.anim.show))
        titleTV.startAnimation(GlobalFun().getAnimation(this@MainActivity,R.anim.move_up_down))
        startBTN.startAnimation(GlobalFun().getAnimation(this@MainActivity,R.anim.move_down_up))
    }

    private fun init(){
        titleTV = findViewById(R.id.titleTV)
        imgIV = findViewById(R.id.imgIV)
        startBTN = findViewById(R.id.startBTN)
    }
}
package com.yin.mvvmdemo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.yin.mvvmdemo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_menu).setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
        findViewById<Button>(R.id.btn_drawer).setOnClickListener {
            startActivity(Intent(this, DrawerActivity::class.java))
        }
        findViewById<Button>(R.id.btn_bottom).setOnClickListener {
            startActivity(Intent(this, BottomActivity::class.java))
        }
    }
}

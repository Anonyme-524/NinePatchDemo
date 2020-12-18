package com.example.ninepatchdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.navigation_fx.*

class My : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        supportActionBar?.hide()//标题弃掉

        wx.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
        }
        txl.setOnClickListener {
            val intent1 = Intent(this, MailListActivity::class.java)
            startActivity(intent1)
        }
        fx.setOnClickListener {
            val intent2 = Intent(this, Find::class.java)
            startActivity(intent2)
        }

    }
}
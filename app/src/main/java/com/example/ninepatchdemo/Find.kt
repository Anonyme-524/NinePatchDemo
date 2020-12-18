package com.example.ninepatchdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.navigation_fx.*
import kotlinx.android.synthetic.main.navigation_fx.wx


class Find : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)
        supportActionBar?.hide()//标题弃掉
        translate.setOnClickListener {
            val intent = Intent(this,Wechat_Moments::class.java)
            startActivity(intent)
        }

        wx.setOnClickListener {
            val intent1 = Intent(this, MainActivity1::class.java)
            startActivity(intent1)
        }
        txl.setOnClickListener {
            val intent2 = Intent(this, MailListActivity::class.java)
            startActivity(intent2)
        }
        wo.setOnClickListener {
            val intent3 = Intent(this, My::class.java)
            startActivity(intent3)
        }

    }
}
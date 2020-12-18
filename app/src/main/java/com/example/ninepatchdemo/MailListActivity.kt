package com.example.ninepatchdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.navigation_fx.*
import kotlinx.android.synthetic.main.wechat_buttom.wx

class MailListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail_list)
        translate.setOnClickListener {
            val intent = Intent(this,Wechat_Moments::class.java)
            startActivity(intent)
        }
        wx.setOnClickListener {
            val intent1 = Intent(this,MainActivity1::class.java)
            startActivity(intent1)
        }
        fx.setOnClickListener {
            val intent2 = Intent(this,MainActivity1::class.java)
            startActivity(intent2)
        }
        wo.setOnClickListener {
            val intent3 = Intent(this,My::class.java)
            startActivity(intent3)
        }
    }
}
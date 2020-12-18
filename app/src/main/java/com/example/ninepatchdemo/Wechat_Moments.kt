package com.example.ninepatchdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.ninepatchdemo.R
import kotlinx.android.synthetic.main.activity_wechat__moments.*


class Wechat_Moments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wechat__moments)
        supportActionBar?.hide()//标题弃掉


    }
}
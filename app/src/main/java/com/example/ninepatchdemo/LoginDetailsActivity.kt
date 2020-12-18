package com.example.ninepatchdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_details.*

class LoginDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_details)
        LoginButton.setOnClickListener {
            val id  = UserID.text.trim().toString()
            val pwd = UserPwd.text.trim().toString()
            if (id == "" && pwd == "")
            {
                Toast.makeText(this,"请输入账号或密码",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, MainActivity1::class.java)
                startActivity(intent)
            }
        }
    }
}

package com.example.ninepatchdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main1.*
import kotlinx.android.synthetic.main.navigation_wx.*
import kotlin.collections.ArrayList

class MainActivity1 : AppCompatActivity() {
//    private val data = listOf("苹果","香蕉","榴莲","橙子","草莓","芒果","哈密瓜","提子","龙眼","荔枝","西瓜","猕猴桃","橘子","番石榴","人参果","黑加仑")
    private val fruitList=ArrayList<Fruit>()

    private fun intiFruits(){
        repeat(2)
        {
            fruitList.add(Fruit("今晚打阿威","测试看看下面区域如果是个整体...",R.drawable.img_11))
            fruitList.add(Fruit("背对背拥抱","中秋国庆快乐",R.drawable.img_2))
            fruitList.add(Fruit("不给糖","中秋国庆快乐",R.drawable.img_3))
            fruitList.add(Fruit("北方","中秋国庆快乐",R.drawable.img_4))
            fruitList.add(Fruit("林妹妹","中秋国庆快乐",R.drawable.img_5))
            fruitList.add(Fruit("顺鱼","中秋国庆快乐",R.drawable.img_6))
            fruitList.add(Fruit("c在g上","中秋国庆快乐",R.drawable.img_7))
            fruitList.add(Fruit("一条小鱼鱼","中秋国庆快乐",R.drawable.img_8))
            fruitList.add(Fruit("cc","中秋国庆快乐",R.drawable.img_9))
            fruitList.add(Fruit("西瓜子","中秋国庆快乐",R.drawable.img_10))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        intiFruits()

        //上下文,列表子视图,数据源
//        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,data)
        val fruitAdapter = FruitAdapter(this,R.layout.fruit_item,fruitList)
        //绑定到控件
//        listViewTest.adapter = adapter
        listViewTest.adapter = fruitAdapter

        listViewTest.setOnItemClickListener { _,_,i,_->
            val fruit=fruitList[i]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        translate.setOnClickListener {
            val intent1 = Intent(this, Wechat_Moments::class.java)
            startActivity(intent1)
        }


        fx.setOnClickListener {
            val intent2 = Intent(this, Find::class.java)
            startActivity(intent2)
        }

        wo.setOnClickListener {
            val intent3 = Intent(this, My::class.java)
            startActivity(intent3)
        }

        txl.setOnClickListener {
            val intent4 = Intent(this,MailListActivity::class.java)
            startActivity(intent4)
        }

    }

}
package com.example.ninepatchdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.wechat_buttom.*

class MainActivity : AppCompatActivity() {

    private var msgDataList=ArrayList<Msg>()
//    private lateinit var adapter:MsgAdapter
    private fun initMsgData() {
        repeat(2)
        {
            Int
            msgDataList.add(
                Msg(R.drawable.img_1, "两个include的高度拉不动", 0)
            )
            msgDataList.add(
                Msg(R.drawable.img_2, "一直是占满界面", 0)
            )
            msgDataList.add(
                Msg(R.drawable.img_3, "直接在界面用控件试试", 1)
            )
            msgDataList.add(
                Msg(R.drawable.img_4, "可以拖了",0)
            )
            msgDataList.add(
                Msg(R.drawable.img_5, "啥也没搞，突然又能拖动了", 0)
            )
            msgDataList.add(
                Msg(R.drawable.img_6, "让人怪不好意思的", 0)
            )
            msgDataList.add(
                Msg(R.drawable.img_7, "为啥一点打字会吃掉一点", 0)
            )
            msgDataList.add(
                Msg(R.drawable.img_3, "测试看看 下面的区域如果是一个整体，设置一点的Top内边距", 1)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //数据初始化
        initMsgData()
        val layoutManager = LinearLayoutManager(this)
        Recycler_view.layoutManager = layoutManager
        //实例化数据适配器，装载数据
        val adapter = MsgAdapter(msgDataList)
        val adapter1 = ScaleInAnimationAdapter(adapter).apply {
            //设置动画时长
            setDuration(500)
        }
        //叠加上面的动画，添加淡出动画
        val adapter2 = AlphaInAnimationAdapter(adapter1).apply {
            setDuration(300)
        }
        Recycler_view.adapter = adapter2
        //滚动到最新数据的位置上
        Recycler_view.scrollToPosition(msgDataList.size - 1)

        msg_send.setOnClickListener {
            val text:String = wechatxx.text.toString()
            if (text.isNotEmpty())
            {
                val list:List<Msg> = adapter.getList()
                if (msgDataList.size != list.size) msgDataList = list as ArrayList<Msg>
                //增加数据到数据源
                msgDataList.add(Msg(R.drawable.img_3,text,1))
                //通知适配器添加了数据
                adapter2.notifyItemInserted(msgDataList.size-1)
                //滚动到最新数据的位置上
                Recycler_view.scrollToPosition(msgDataList.size - 1)
                //清空输入框数据
                wechatxx.setText("")
            }
        }

        rootLayout.addOnLayoutChangeListener { _, _, _, _, bottom, _, _, _, oldBottom ->
            if (oldBottom != -1 && oldBottom > bottom ){
                Recycler_view.requestLayout()
                Recycler_view.post { Recycler_view.scrollToPosition(msgDataList.size - 1) }
            }
        }
    }
}
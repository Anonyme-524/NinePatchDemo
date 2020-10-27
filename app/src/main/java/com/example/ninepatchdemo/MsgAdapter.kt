package com.example.ninepatchdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException


class MsgAdapter(var msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {



    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType ==Msg.TYPE_LEFT){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item,parent,false)
            LeftViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item,parent,false)
            val viewHolder = RightViewHolder(view)
        //设置长按事件监听器
        viewHolder.itemView.setOnLongClickListener {
                msgList -= msgList[viewHolder.adapterPosition]
                //notifyItemRemoved(rightViewHolder.adapterPosition)
                notifyItemRemoved(viewHolder.adapterPosition)
                true
            }
        viewHolder
    }

    override fun getItemCount()= msgList.size

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder){
            is LeftViewHolder ->{
                holder.leftMsg.text = msg.content
                holder.imageId.setImageResource(msg.imageId)

            }
            is RightViewHolder ->{
                holder.rightMsg.text = msg.content
                holder.imageId.setImageResource(msg.imageId)
            }
        }
    }
    //获取适配器的数据源
    fun getList() = msgList
}
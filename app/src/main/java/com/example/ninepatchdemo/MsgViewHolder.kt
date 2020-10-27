package com.example.ninepatchdemo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

sealed class MsgViewHolder(view:View):RecyclerView.ViewHolder(view)

 class LeftViewHolder(view:View) : MsgViewHolder(view){
    val leftMsg : TextView = view.findViewById(R.id.leftMsg)
    val imageId: ImageView = view.findViewById(R.id.touxiang)
}

 class RightViewHolder(view: View) : MsgViewHolder(view){
    val rightMsg : TextView = view.findViewById(R.id.rightMsg)
    val imageId: ImageView = view.findViewById(R.id.touxiang2)
}
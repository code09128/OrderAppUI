package com.ezaio.orderapp.view.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.ezaio.mobilewalletdashboard.view.adapter.BaseRecyclerAdapter
import com.ezaio.orderapp.R
import com.ezaio.orderapp.category.PopularFoodData
import com.ezaio.orderapp.view.ShowDetailActivity


/**
 * @auther dustin.hsieh
 * @Date on 2023/6/27
 * @Description
 */
class PopularAdapter(var popularFoodData:ArrayList<PopularFoodData>,val context:Context): BaseRecyclerAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = holder.getView<TextView>(R.id.tvTitle)
        val pic = holder.getView<ImageView>(R.id.ivFoodPic)
        val fee = holder.getView<TextView>(R.id.tvfee)
        val addBtn = holder.getView<TextView>(R.id.addBtn)

        name.text = popularFoodData[position].title
        fee.text = popularFoodData[position].fee.toString()

        // get drawable icon package name
        val drawables = holder.itemView.context.resources.getIdentifier(popularFoodData[position].pic,"drawable",
            holder.itemView.context.packageName
        )

        // use Glide set item logo
        Glide.with(holder.itemView.context).load(drawables).into(pic)

        addBtn.setOnClickListener {
            val intent = Intent(context, ShowDetailActivity::class.java)
            intent.putExtra("object", popularFoodData[position])
            context.startActivity(intent)
            Log.d("addBtn","$position")
        }
    }

    override fun getItemCount(): Int {
        return popularFoodData.size
    }
}
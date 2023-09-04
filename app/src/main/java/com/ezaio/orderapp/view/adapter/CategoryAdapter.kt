package com.ezaio.orderapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ezaio.mobilewalletdashboard.view.adapter.BaseRecyclerAdapter
import com.ezaio.orderapp.R
import com.ezaio.orderapp.category.Category

/**
 * @auther dustin.hsieh
 * @Date on 2023/6/16
 * @Description
 */
class CategoryAdapter(var category: ArrayList<Category>): BaseRecyclerAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var name = holder.getView<TextView>(R.id.tvCategoryTitle)
        val pic = holder.getView<ImageView>(R.id.ivCategoryPic)

        name.text = category[position].title

        // get drawable icon package name
        val drawables = holder.itemView.context.resources.getIdentifier(category[position].pic,"drawable",
            holder.itemView.context.packageName
        )

        // use Glide set item logo
        Glide.with(holder.itemView.context).load(drawables).into(pic)

        when(position){
            0 -> {
                holder.itemView.setBackgroundResource(R.drawable.cat_background1)
            }
            1 -> {
                holder.itemView.setBackgroundResource(R.drawable.cat_background2)
            }
            2 -> {
                holder.itemView.setBackgroundResource(R.drawable.cat_background3)
            }
            3 -> {
                holder.itemView.setBackgroundResource(R.drawable.cat_background4)
            }
            4 -> {
                holder.itemView.setBackgroundResource(R.drawable.cat_background5)
            }
        }
    }

    override fun getItemCount(): Int {
        return category.size
    }
}
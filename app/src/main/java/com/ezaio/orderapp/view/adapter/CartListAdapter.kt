package com.ezaio.orderapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ezaio.mobilewalletdashboard.view.adapter.BaseRecyclerAdapter
import com.ezaio.orderapp.ManagerCart
import com.ezaio.orderapp.R
import com.ezaio.orderapp.category.PopularFoodData

/**
 * @auther dustin.hsieh
 * @Date on 2023/8/28
 * @Description
 */
class CartListAdapter(var popularFoodData: ArrayList<PopularFoodData>?): BaseRecyclerAdapter(){
    interface OnChangeItemListener {
        fun onChange()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartPic = holder.getView<ImageView>(R.id.picCart)
        val cartTitle = holder.getView<TextView>(R.id.tvCartTitle)
        val numberItem = holder.getView<TextView>(R.id.tvNumberItem)
        val feeEachItem = holder.getView<TextView>(R.id.tvFeeEachItem)
        val totalItem = holder.getView<TextView>(R.id.tvTotalEachItem)
        val minusBtn = holder.getView<ImageView>(R.id.minusCartBtn)
        val plusBtn = holder.getView<ImageView>(R.id.plusCartBtn)

        cartTitle.text = popularFoodData?.get(position)?.title
        feeEachItem.text = popularFoodData?.get(position)?.fee.toString()
        totalItem.text =
            (Math.round((popularFoodData?.get(position)?.numberInCar)!! * (popularFoodData!![position].fee)* 100)/100).toString()
        numberItem.text = popularFoodData!![position].numberInCar.toString()

        val drawables = holder.itemView.context.resources.getIdentifier(
            popularFoodData!![position].pic,"drawable",
            holder.itemView.context.packageName
        )

        // use Glide set item logo
        Glide.with(holder.itemView.context).load(drawables).into(cartPic)

        plusBtn.setOnClickListener {
            ManagerCart.plusNumberFood(popularFoodData!!,position)
            notifyDataSetChanged()
        }

        minusBtn.setOnClickListener {
            ManagerCart.minusNumberFood(popularFoodData!!,position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return popularFoodData?.size ?: 0
    }

}
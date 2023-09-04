package com.ezaio.orderapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ezaio.orderapp.ManagerCart
import com.ezaio.orderapp.R
import com.ezaio.orderapp.category.PopularFoodData
import kotlinx.android.synthetic.main.activity_show_detail.*
import kotlinx.android.synthetic.main.activity_show_detail.tvTitle
import kotlinx.android.synthetic.main.popular_item.*

class ShowDetailActivity : AppCompatActivity() {
    private var numberOrder = 0
    val manager = ManagerCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        getBundleData()
    }

    @SuppressLint("SetTextI18n")
    private fun getBundleData() {
        val data = intent.getParcelableExtra("object") as PopularFoodData?

        Log.d("ShowDetail",data.toString())

        val drawables = this.resources.getIdentifier(
            data!!.pic,"drawable",
            this.packageName
        )

        // use Glide set item logo
        Glide.with(this).load(drawables).into(ivFood)

        tvTitle.text = data!!.title
        tvPrice.text = "$"+ data.fee
        tvDescription.text = data.description
        tvNumberOrder.text = numberOrder.toString()

        ivPlus.setOnClickListener {
            numberOrder += 1
            tvNumberOrder.text = numberOrder.toString()

            Log.d("numberOrder", numberOrder.toString())
        }

        ivMinus.setOnClickListener {
            tvNumberOrder.text = numberOrder.toString()
            if (numberOrder > 1) {
                numberOrder -= 1
                tvNumberOrder.text = numberOrder.toString()
                Log.d("numberOrder", numberOrder.toString())
            }
        }

        addToCartBtn.setOnClickListener {
            Toast.makeText(this,"add to your card",Toast.LENGTH_LONG).show()

            data.numberInCar = numberOrder
            manager.insertFood(data,this)
        }
    }
}
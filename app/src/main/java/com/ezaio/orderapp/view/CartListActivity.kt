package com.ezaio.orderapp.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ezaio.orderapp.ManagerCart
import com.ezaio.orderapp.R
import com.ezaio.orderapp.category.PopularFoodData
import com.ezaio.orderapp.view.adapter.CartListAdapter
import kotlinx.android.synthetic.main.activity_cart_list.*

class CartListActivity : AppCompatActivity() {
    lateinit var cartListAdapter: CartListAdapter
    private var popularData:ArrayList<PopularFoodData>? = null

    val manager = ManagerCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_list)

        initView()
        bottomNavigation()
    }

    private fun bottomNavigation() {
        cartBtn.setOnClickListener {
            startActivity(Intent(this, IntroActivity::class.java))
        }
    }

    @SuppressLint("WrongConstant")
    private fun initView() {
        rCartRecycleView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        rCartRecycleView.layoutManager = layoutManager

        cartListAdapter = CartListAdapter(null)
        rCartRecycleView.adapter = cartListAdapter
    }
}
package com.ezaio.orderapp.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ezaio.orderapp.ManagerCart
import com.ezaio.orderapp.R
import com.ezaio.orderapp.category.Category
import com.ezaio.orderapp.category.PopularFoodData
import com.ezaio.orderapp.view.adapter.CategoryAdapter
import com.ezaio.orderapp.view.adapter.PopularAdapter
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var popularAdapter: PopularAdapter

    private var categoryData:ArrayList<Category>? = null
    private var popularData:ArrayList<PopularFoodData>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        initCategoryData()
        initPopularFoodData()
        bottom()
    }

    private fun bottom() {
        homeCartBtn.setOnClickListener {
            startActivity(Intent(this, CartListActivity::class.java))
        }
    }

    @SuppressLint("WrongConstant")
    private fun initPopularFoodData() {
        rPopular.setHasFixedSize(true)
        val layoutManager =LinearLayoutManager(this, LinearLayout.HORIZONTAL,false)
        rPopular.layoutManager = layoutManager

        popularData = ArrayList()

        val popularFoodData1 = PopularFoodData("Peperoni pizza","pop_1","slices peperoni,mozzerella cheese,fresh oregano,pizza sauce,black pepper",8.75,null)
        val popularFoodData2 = PopularFoodData("Cheese Burger","pop_2","beef, Gouda Cheese, Special Sauce, tomato,Lettuce",8.56,null)
        val popularFoodData3 = PopularFoodData("Vegetable pizza","pop_3","olive oil, Vegetable oil, pitted kalamata, cherry, basil",8.75,null)

        popularData!!.add(popularFoodData1)
        popularData!!.add(popularFoodData2)
        popularData!!.add(popularFoodData3)

        popularAdapter = PopularAdapter(popularData!!,this)
        rPopular.adapter = popularAdapter
    }

    @SuppressLint("WrongConstant")
    private fun initCategoryData() {
        rCategories.setHasFixedSize(true)
        val layoutManager =LinearLayoutManager(this, LinearLayout.HORIZONTAL,false)
        rCategories.layoutManager = layoutManager

        categoryData = ArrayList()

        val category1 = Category("pizza","cat_1")
        val category2 = Category("Burger","cat_2")
        val category3 = Category("Hotdog","cat_3")
        val category4 = Category("Drink","cat_4")
        val category5 = Category("Donut","cat_5")

        categoryData!!.add(category1)
        categoryData!!.add(category2)
        categoryData!!.add(category3)
        categoryData!!.add(category4)
        categoryData!!.add(category5)

        categoryAdapter = CategoryAdapter(categoryData!!)
        rCategories.adapter = categoryAdapter
    }
}
package com.ezaio.orderapp

import android.content.Context
import android.widget.Toast
import com.ezaio.orderapp.category.PopularFoodData
import com.ezaio.orderapp.view.adapter.CartListAdapter

/**
 * @auther dustin.hsieh
 * @Date on 2023/6/29
 * @Description
 */
object ManagerCart {
    private val FOOD_DB: FoodDB? = null
    var existAlready = false
    var n = 0

    fun insertFood(item:PopularFoodData,context:Context){
        val listFood:ArrayList<PopularFoodData> = getListCart()

        for (listFoods in listFood){
            if (listFoods.title == item.title){
                existAlready = true
                n = listFood.size
                break
            }
        }

        if (existAlready){
            listFood[n].numberInCar = item.numberInCar
        }
        else{
            listFood.add(item)
        }

        FOOD_DB!!.putListObject("CartList",listFood)
        Toast.makeText(context,"Added To Your Cart",Toast.LENGTH_SHORT).show()
    }

    private fun getListCart(): ArrayList<PopularFoodData> {
        return FOOD_DB!!.getListObject("CartList")
    }

    fun plusNumberFood(listFood:ArrayList<PopularFoodData>,position:Int){
        listFood[position].numberInCar = listFood[position].numberInCar?.plus(1)
        FOOD_DB!!.putListObject("CartList",listFood)
    }

    fun minusNumberFood(listFood:ArrayList<PopularFoodData>,position:Int){
        if (listFood[position].numberInCar == 1){
            listFood.removeAt(position)
        }
        else {
            listFood[position].numberInCar = listFood[position].numberInCar?.minus(1)

        }

        FOOD_DB!!.putListObject("CartList",listFood)
    }

    fun getTitleFee():Double {
        val listFood:ArrayList<PopularFoodData> = getListCart()

        var fee:Double = 0.0

        for (i in listFood){
            fee = fee.plus(i.fee * i.numberInCar!!)
        }

        return fee
    }
}
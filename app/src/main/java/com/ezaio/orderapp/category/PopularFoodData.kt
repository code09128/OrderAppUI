package com.ezaio.orderapp.category

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @auther dustin.hsieh
 * @Date on 2023/6/27
 * @Description
 */
@Parcelize
data class PopularFoodData(
    var title:String,
    var pic:String,
    var description:String,
    var fee:Double,
    var numberInCar:Int?,
):Parcelable {

}
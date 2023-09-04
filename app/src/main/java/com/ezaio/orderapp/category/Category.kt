package com.ezaio.orderapp.category

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @auther dustin.hsieh
 * @Date on 2023/6/26
 * @Description
 */
@Parcelize
class Category(
    var title:String,
    var pic:String
): Parcelable {

}
package com.example.fooddelivery.data

import androidx.annotation.DrawableRes
import com.example.fooddelivery.R

data class ProductFlavorState(
    val name: String,
    val price: String,
    @DrawableRes val imgRes: Int
)


val ProductFlavorsData = listOf(
    ProductFlavorState(
        imgRes = R.drawable.img_cheese,
        name = "Cheeder",
        price = "$0.79"
    ),
    ProductFlavorState(
        imgRes = R.drawable.img_bacon,
        name = "Bacon",
        price = "$0.52"
    ),
    ProductFlavorState(
        imgRes = R.drawable.img_onion,
        name = "Onion",
        price = "$0.28"
    )

)
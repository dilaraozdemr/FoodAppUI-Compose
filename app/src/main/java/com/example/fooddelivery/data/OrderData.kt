package com.example.fooddelivery.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


data class OrderState(
    val amount: Int,
    val totalPrice: String
)

val OrderData = OrderState(
    amount = 5,
    totalPrice = "$27.45"
)
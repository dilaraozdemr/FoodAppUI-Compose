package com.example.fooddelivery.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.data.OrderData
import com.example.fooddelivery.data.OrderState
import com.example.fooddelivery.data.ProductDescriptionData
import com.example.fooddelivery.data.ProductFlavorState
import com.example.fooddelivery.data.ProductFlavorsData
import com.example.fooddelivery.data.ProductNutritionData
import com.example.fooddelivery.data.ProductNutritionState
import com.example.fooddelivery.data.ProductPreviewState
import com.example.fooddelivery.ui.screen.components.FlavorSection
import com.example.fooddelivery.ui.screen.components.OrderActionBar
import com.example.fooddelivery.ui.screen.components.ProductDescriptionSection
import com.example.fooddelivery.ui.screen.components.ProductNutritionSection
import com.example.fooddelivery.ui.screen.components.ProductPreviewSection

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState = ProductPreviewState(),
    productFlavors: List<ProductFlavorState> = ProductFlavorsData,
    productNutritionState: ProductNutritionState = ProductNutritionData,
    productDescription: String = ProductDescriptionData,
    orderState: OrderState = OrderData,
    onAddItemClicked: () -> Unit,
    onRemoveItemClicked: () -> Unit,
    onCheckOutClicked: () -> Unit

) {

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Content(
            productPreviewState = productPreviewState,
            productFlavors = productFlavors,
            productNutritionState = productNutritionState,
            productDescription = productDescription
        )
        OrderActionBar(
            state = orderState,
            onAddItemClicked = onAddItemClicked,
            onRemoveItemClicked = onRemoveItemClicked,
            onCheckOutClicked = onCheckOutClicked,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(
                    horizontal = 18.dp,
                    vertical = 8.dp
                )
        )
    }

}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState,
    productFlavors: List<ProductFlavorState>,
    productNutritionState: ProductNutritionState,
    productDescription: String

) {
    val scrollableState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollableState)
    ) {
        ProductPreviewSection(
            state = productPreviewState
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlavorSection(
            modifier = Modifier.padding(horizontal = 18.dp),
            data = productFlavors
        )
        ProductNutritionSection(
            modifier = modifier.padding(horizontal = 18.dp),
            state = productNutritionState
        )
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        ProductDescriptionSection(
            productDescription = productDescription,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(horizontal = 18.dp)
                .padding(bottom = 128.dp)
        )
    }
}
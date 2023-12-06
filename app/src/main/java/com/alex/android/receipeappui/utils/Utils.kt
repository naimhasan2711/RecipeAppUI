package com.alex.android.receipeappui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

class Utils {
    companion object{
        @Composable
        fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }


        @Composable
        fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }
    }
}
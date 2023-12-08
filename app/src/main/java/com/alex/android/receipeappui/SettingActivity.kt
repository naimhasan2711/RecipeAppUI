package com.alex.android.receipeappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alex.android.receipeappui.screens.SettingsScreen
import com.alex.android.receipeappui.ui.theme.ReceipeAppUITheme

class SettingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReceipeAppUITheme {
                SettingsScreen()
            }
        }
    }
}

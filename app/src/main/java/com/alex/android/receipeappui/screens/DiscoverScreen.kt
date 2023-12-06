package com.alex.android.receipeappui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alex.android.receipeappui.R
import com.alex.android.receipeappui.Screens
import com.alex.android.receipeappui.ui.theme.ReceipeAppUITheme
import com.alex.android.receipeappui.ui.theme.TopBarColor

@Composable
fun DiscoverScreen(navController: NavController) {
    ReceipeAppUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Red
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                RowWithCenteredTextAndIconButton(navController)
            }
//            Column(
//                modifier = Modifier.fillMaxSize().padding(15.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Box(
//                    modifier = Modifier.fillMaxSize().background(Color.Red)
//                        .clip(MaterialTheme.shapes.large)
//                ) {
//
//                }
//                Text(
//                    "Discover Screen",
//                    style = MaterialTheme.typography.titleLarge,
//                    modifier = Modifier.padding(vertical = 20.dp)
//                )
//            }
        }
    }
}


@Composable
fun RowWithCenteredTextAndIconButton(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(TopBarColor),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Discover",
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.CenterHorizontally),
            style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )

        IconButton(
            onClick = {
                navController.navigate(Screens.Settings.route)
            },
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.setting),
                contentDescription = "Send"
            )
        }
    }
}
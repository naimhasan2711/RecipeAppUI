package com.alex.android.receipeappui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.android.receipeappui.MainActivity
import com.alex.android.receipeappui.R
import com.alex.android.receipeappui.components.FilterChipGroup
import com.alex.android.receipeappui.ui.theme.ReceipeAppUITheme
import com.alex.android.receipeappui.ui.theme.roboto

@Composable
fun SettingsScreen() {
    ReceipeAppUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = Color.Red
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                RowWithCenteredTextAndIconButtonSettings()
                Spacer(modifier = Modifier.height(12.dp))
                EditProfileSection()
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Personal Preference",
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    style = TextStyle(
                        fontSize = 28.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),

                        )
                )
                Spacer(modifier = Modifier.height(60.dp))
                Text(
                    text = "Dietary Requirements",
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),

                        )
                )
                FilterChipGroup(items = listOf("Vegetarian", "Vegan", "Diabetic", "Random"))
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Allergies",
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        )
                )
                FilterChipGroup(items = listOf("Peanut", "Shellfish", "Diary", "Random"))
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Favorite Cuisine",
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(
                    modifier = Modifier.padding(start = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(5) {
                        CardWithImageAndTitle(
                            "American", painterResource(id = R.drawable.hamburger_)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RowWithCenteredTextAndIconButtonSettings() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.5.dp)
            .background(color = Color(0xFFFEF7FF)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }, modifier = Modifier
                .size(48.dp)
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cross_icon), contentDescription = "Send"
            )
        }
        Text(
            text = "Settings",
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.CenterHorizontally),
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = roboto
            )
        )

    }
}

@Composable
fun EditProfileSection(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(105.dp)
            .padding(horizontal = 24.dp)
            .background(color = Color(0xFFFEF7FF), shape = RoundedCornerShape(30.dp))
            .clip(RoundedCornerShape(30.dp))
            .border(width = 1.dp, color = Color(0xFFCAC4D0), shape = RoundedCornerShape(30.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = painterResource(id = R.drawable.monogram),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(start = 24.dp),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "John Doe",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF1D1B20),
                    letterSpacing = 0.15.sp,
                )
            )

            Text(
                text = "@john",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF1D1B20),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.25.sp,
                )
            )

        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            modifier = Modifier.padding(end = 24.dp),
            text = "Edit Profile",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF6750A4),
                textAlign = TextAlign.Center,
                letterSpacing = 0.1.sp,
            )
        )
    }
}
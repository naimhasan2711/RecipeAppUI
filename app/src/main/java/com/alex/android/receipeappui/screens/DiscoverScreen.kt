package com.alex.android.receipeappui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alex.android.receipeappui.R
import com.alex.android.receipeappui.Screens
import com.alex.android.receipeappui.ui.theme.ReceipeAppUITheme
import com.alex.android.receipeappui.ui.theme.SmallCardBgColor
import com.alex.android.receipeappui.ui.theme.TopBarColor
import com.alex.android.receipeappui.ui.theme.ViewAllTextColor


@Composable
fun DiscoverScreen(navController: NavController) {
    ReceipeAppUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = Color.Red
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                RowWithCenteredTextAndIconButton(navController)
                Spacer(modifier = Modifier.height(12.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(1) {
                        CardWithImageAndTitle(
                            "American", painterResource(id = R.drawable.hamburger_)
                        )
                        CardWithImageAndTitle("Spanish", painterResource(id = R.drawable.food_))
                        CardWithImageAndTitle("Italian", painterResource(id = R.drawable.pizza_))
                        CardWithImageAndTitle("Chinese", painterResource(id = R.drawable.sushi_))
                        CardWithImageAndTitle("Spanish", painterResource(id = R.drawable.food_))
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                RowWithTwoText(firstText = "Featured Recipes", secondText = "View All")
            }
        }
    }
}


@Composable
fun RowWithCenteredTextAndIconButton(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(0.dp))
            .padding(2.dp)
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
            }, modifier = Modifier
                .size(48.dp)
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.setting), contentDescription = "Send"
            )
        }
    }
}

@Composable
fun CardWithImageAndTitle(
    title: String, painter: Painter
) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .width(120.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(MaterialTheme.colorScheme.onBackground),
        colors = CardDefaults.cardColors(
            containerColor = SmallCardBgColor, //Card background color
            contentColor = Color.Black  //Card content color,e.g.text
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .aspectRatio(1.2f),
                alignment = Alignment.Center

            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun RowWithTwoText(firstText:String, secondText:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = firstText,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            textAlign = TextAlign.Start,
            style = TextStyle(
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal
            )
        )
        Text(
            text = secondText,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            textAlign = TextAlign.End,
            style = TextStyle(
                color = ViewAllTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}
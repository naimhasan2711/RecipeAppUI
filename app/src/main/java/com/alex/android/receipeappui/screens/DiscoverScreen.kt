package com.alex.android.receipeappui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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
                Spacer(modifier = Modifier.height(4.dp))

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(1) {
                        CardWithImageAndRows(
                            painterResource(id = R.drawable.media),
                            "Chicken Zoodle\nSoup in a Jar",
                            "10 mins"
                        )

                        CardWithImageAndRows(
                            painterResource(id = R.drawable.media3),
                            "Iced Dried Cherry\nBiscuits",
                            "25+15 mins"
                        )
                        CardWithImageAndRows(
                            painterResource(id = R.drawable.media2),
                            "Grilled Pizza\n",
                            "50 + 12 mins"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))
                RowWithTwoText(firstText = "Trending Recipes", secondText = "View All")
                Spacer(modifier = Modifier.height(4.dp))
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(1) {
                        CardWithImageAndRows(
                            painterResource(id = R.drawable.media5),
                            "Chicken Zoodle\nSoup in a Jar",
                            "10 mins"
                        )

                        CardWithImageAndRows(
                            painterResource(id = R.drawable.media4),
                            "Iced Dried Cherry\nBiscuits",
                            "25+15 mins"
                        )
                        CardWithImageAndRows(
                            painterResource(id = R.drawable.media3),
                            "Grilled Pizza\n",
                            "50 + 12 mins"
                        )
                    }
                }
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
fun RowWithTwoText(firstText: String, secondText: String) {
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

@Composable
fun CardWithImageAndRows(painter: Painter, title: String, subtitle: String) {
    Card(
        modifier = Modifier
            .height(220.dp)
            .width(220.dp)
            .padding(start = 4.dp, end = 8.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(MaterialTheme.colorScheme.primary)
            .shadow(8.dp, RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            // Upper half - Drawable Image
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Lower half - Two Rows
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            ) {
                // First Row with Text
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )

                // Second Row with Text and Two Drawable Images
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Text(
                        text = subtitle,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.chef_hat_),
                        contentDescription = null,
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.dollar_),
                        contentDescription = null,
                        modifier = Modifier
                            .height(40.dp)
                            .width(25.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
    }
}
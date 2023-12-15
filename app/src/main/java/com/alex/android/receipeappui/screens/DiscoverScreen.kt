package com.alex.android.receipeappui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alex.android.receipeappui.R
import com.alex.android.receipeappui.SettingActivity
import com.alex.android.receipeappui.ui.theme.ReceipeAppUITheme
import com.alex.android.receipeappui.ui.theme.roboto


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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
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
                    Spacer(modifier = Modifier.height(16.dp))
                    RowWithTwoText(firstText = "Featured Recipes", secondText = "View All")
                    Spacer(modifier = Modifier.height(12.dp))

                    LazyRow(
                        modifier = Modifier.padding(start = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(3) {
                            CardWithImageAndRows(
                                painterResource(id = R.drawable.media3),
                                "Iced Dried Cherry\nBiscuits",
                                "25+15 mins"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    RowWithTwoText(firstText = "Trending Recipes", secondText = "View All")
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(
                        modifier = Modifier.padding(start = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(3) {
                            CardWithImageAndRows(
                                painterResource(id = R.drawable.media5),
                                "Chicken Zoodle\nSoup in a Jar",
                                "10 mins"
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    RowWithTwoText(firstText = "Easy Recipes", secondText = "View All")
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(
                        modifier = Modifier.padding(start = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(5) {
                            CardWithImageAndRows(
                                painterResource(id = R.drawable.media5),
                                "Iced Dried Cherry\nBiscuits",
                                "10 mins"
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
}


@Composable
fun RowWithCenteredTextAndIconButton(navController: NavController) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.5.dp)
            .padding(start = 4.dp, top = 1.dp, end = 4.dp, bottom = 0.dp)
            .background(color = Color(0xFFFEF7FF)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Discover",
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

        IconButton(
            onClick = {
                val intent = Intent(context, SettingActivity::class.java)
                context.startActivity(intent)
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
            .height(108.dp)
            .width(102.dp)
            .padding(1.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(color = Color(0xFFEABFBF)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEABFBF), //Card background color
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
                    .height(36.dp)
                    .width(36.dp),
                alignment = Alignment.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                ),
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
                .padding(start = 16.dp),
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
            )
        )
        Text(
            text = secondText,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            textAlign = TextAlign.End,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight(500),
                color = Color(0xFF6750A4),
                textAlign = TextAlign.Center,
                letterSpacing = 0.1.sp,
            )
        )
    }
}

@Composable
fun CardWithImageAndRows(painter: Painter, title: String, subtitle: String) {
    Card(
        modifier = Modifier
            .shadow(elevation = 4.dp, spotColor = Color(0xFFFAD5FF), ambientColor = Color(0xFFFAD5FF),shape = RoundedCornerShape(size = 28.dp))
            .background(color = Color(0xFFFFFFFF))
            .clip(RoundedCornerShape(28.dp))
            .height(240.dp)
            .width(240.dp)
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF), //Card background color
            contentColor = Color.Black  //Card content color,e.g.text
        )
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
                    .width(240.dp)
                    .height(105.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Lower half - Two Rows
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(135.dp)
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            ) {
                // First Row with Text
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF1D1B20),
                        letterSpacing = 0.5.sp,
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
                            fontSize = 21.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_thin)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF49454F),
                            letterSpacing = 0.25.sp,
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.chef_hat_),
                        contentDescription = null,
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp),
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
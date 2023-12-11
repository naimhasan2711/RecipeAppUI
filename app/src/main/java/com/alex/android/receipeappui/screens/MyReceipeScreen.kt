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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import com.alex.android.receipeappui.MainActivity
import com.alex.android.receipeappui.R
import com.alex.android.receipeappui.ui.theme.ReceipeAppUITheme
import com.alex.android.receipeappui.ui.theme.roboto

@Composable
fun MyRecipeScreen(navController: NavController) {
    ReceipeAppUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                RowWithCenteredTextAndIconButtonMyRecipes()
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    RowWithTwoText(firstText = "Latest Recipes", secondText = "View All")
                    Spacer(modifier = Modifier.height(12.dp))
                    CardWithImageAndRowsMyRecipes(painterResource(id = R.drawable.card_image))
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier
                            .width(216.dp)
                            .height(31.dp)
                            .padding(start = 16.dp),
                        text = "Your List",
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.inter_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000)
                        )
                    )
                    CustomRow()
                    Spacer(modifier = Modifier.height(1.dp).background(Color.Gray))
                    CustomRow()
                    Spacer(modifier = Modifier.height(1.dp).background(Color.Gray))
                    CustomRow()
                    Spacer(modifier = Modifier.height(1.dp).background(Color.Gray))
                    CustomRow()
                    Spacer(modifier = Modifier.height(1.dp).background(Color.Gray))
                    CustomRow()
                    Spacer(modifier = Modifier.height(160.dp).background(Color.Gray))
                }
            }
        }
    }
}

@Composable
fun RowWithCenteredTextAndIconButtonMyRecipes() {
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
            text = "My Recipes",
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.CenterHorizontally),
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = roboto
            )
        )

    }
}

@Composable
fun CardWithImageAndRowsMyRecipes(painter: Painter) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp)
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0xFFFAD5FF),
                ambientColor = Color(0xFFFAD5FF),
                shape = RoundedCornerShape(size = 28.dp)
            )
            .background(color = Color(0xFFA79F9F))
            .clip(RoundedCornerShape(28.dp))
            .width(383.dp)
            .height(374.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF), //Card background color
            contentColor = Color.Black  //Card content color,e.g.text
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .width(383.dp)
                    .height(134.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(4.dp))
            // Lower half - Two Rows
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
            ) {
                // First Row with Text
                Text(
                    text = "Chicken a Zoodle Soup in a Jar",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF1D1B20),

                        letterSpacing = 0.5.sp,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = "10 mins",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_thin)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF49454F),
                        letterSpacing = 0.25.sp,
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "These Chicken a Zoodle Soup Jars are a perfect low-carb meal prep idea. Just add boiling water, microwave and enjoy!",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF49454F),

                        letterSpacing = 0.25.sp,
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
                    verticalAlignment = Alignment.Top,
                ) {
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
                    Spacer(modifier = Modifier.width(24.dp))
                    ButtonWithIconSample()
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6750A4)
                        )
                    ) {
                        Text(text = "Cook It!")
                    }
                }

            }
        }
    }
}

@Composable
fun ButtonWithIconSample() {
    OutlinedButton(modifier = Modifier
        .border(
            width = 1.dp,
            color = Color(0xFF79747E),
            shape = RoundedCornerShape(size = 100.dp)
        )
        .width(150.dp)
        .height(40.dp)
        .padding(0.dp),
        onClick = { /* Do something! */ }) {
        Text(
            text = "Add to my list",
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
fun CustomRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(93.dp)
            .background(color = Color(0xFFFEF7FF)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_thumb),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .padding(start = 8.dp)
                .background(MaterialTheme.colorScheme.primary)
        )
        // Spacer for separation
        Spacer(modifier = Modifier.width(16.dp))
        // Column with two Text elements
        Column {
            Text(
                text = "Added 3 days ago",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_thin)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF49454F),
                    letterSpacing = 0.5.sp,
                )
            )
            Text(
                text = "Grilled Pizza",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF1D1B20),
                    letterSpacing = 0.5.sp,
                )
            )
        }

        // Spacer for separation
        Spacer(modifier = Modifier.width(16.dp))

        // IconButton
        IconButton(
            onClick = {

            }, modifier = Modifier
                .size(48.dp)
                .padding(8.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cross_icon), contentDescription = "Send"
            )
        }
    }
}
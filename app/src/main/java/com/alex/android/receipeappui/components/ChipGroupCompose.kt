package com.alex.android.receipeappui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilterChipGroup(
    items: List<String>,
) {
    LazyRow(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(30.dp)),
        userScrollEnabled = true
    )
    {
        items(items.size) { index: Int ->
            FilterChipM3(items[index])
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipM3(title:String) {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        modifier = Modifier.width(120.dp).height(60.dp).background(if (selected) Color.Red else Color.Transparent),
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = title)},
        shape = RoundedCornerShape(0.dp),

        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = null,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else null,
    )
}
@Preview
@Composable
fun PreviewFilterChipGroup() {
    FilterChipGroup(items = listOf("POST", "GET", "DELETE", "PUT"))
}
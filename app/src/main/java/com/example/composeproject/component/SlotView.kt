package com.example.composeproject.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeproject.ui.theme.card
import com.example.composeproject.ui.theme.text

@Composable
fun slotViewOne(modifier: Modifier = Modifier,value: String) {
    Box(
        modifier = modifier,
            contentAlignment = Alignment.Center
    ) {
        Text(text = value, color = text, modifier = Modifier.padding(20.dp),fontSize = 14.sp)
    }
}
@Composable
fun slotViewTwo(modifier: Modifier = Modifier,value: String) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = value, color = card, modifier = Modifier.padding(20.dp),fontSize = 14.sp)
    }
}

@Composable
fun cardTextViewUi(value: String, onClickValue: () -> Unit)
{
    Card(elevation = 4.dp,shape = RoundedCornerShape(80.dp))
    {
        Text(text = value, color = text,
            modifier = Modifier.padding(20.dp).clickable { onClickValue.invoke() })
    }
}

@Preview
@Composable
fun slotViewOnePreview()
{
    Row() {
        slotViewOne(
            Modifier
                .weight(1f)
                .background(color = MaterialTheme.colors.background),"Person")
        slotViewTwo(
            Modifier
                .weight(1f)
                .background(color = MaterialTheme.colors.background),"Momentum")
    }
}

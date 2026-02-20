package io.github.sadeghi.geminichat.ui.detailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatBubble(massage: String, isFromUser: Boolean) {

    val backgroundColor =
        if (isFromUser) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
    val textColor = if (isFromUser) MaterialTheme.colorScheme.onPrimary
    else MaterialTheme.colorScheme.onSurface

    val bubbleShape = if (isFromUser) {
        RoundedCornerShape(
            topStart = 16.dp, bottomStart = 16.dp,
            bottomEnd = 0.dp, topEnd = 16.dp
        )
    } else {

        RoundedCornerShape(
            topStart = 16.dp, bottomStart = 0.dp,
            bottomEnd = 16.dp, topEnd = 16.dp
        )

    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isFromUser) Arrangement.End else Arrangement.Start
    )
    {
        Box(
            modifier = Modifier
                .padding(6.dp)
                .shadow(6.dp, bubbleShape)
                .background(backgroundColor, bubbleShape)
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Text(
                text = massage,
                color = textColor,
                fontSize = 16.sp,

                )
        }
    }
}
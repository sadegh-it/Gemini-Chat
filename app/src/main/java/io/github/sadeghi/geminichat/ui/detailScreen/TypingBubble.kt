package io.github.sadeghi.geminichat.ui.detailScreen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.sadeghi.geminichat.ui.components.SpacerWidth

@Composable
fun TypingBubble() {

    val infiniteTransition = rememberInfiniteTransition()

    val dots by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 4f,
        animationSpec = infiniteRepeatable(tween(1500, easing = LinearEasing))
    )

    val dotCount = dots.toInt() % 5


    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(
                MaterialTheme.colorScheme.surface, RoundedCornerShape(
                    16.dp
                )
            )
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {

        Text(
            "جمنای در حال تایپ کردن", fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        SpacerWidth(8)

        repeat(dotCount) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(3.dp)),

                )
            SpacerWidth(8)

        }

    }

}
package io.github.sadeghi.geminichat.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    text: String = "ارسال",
    enabled: Boolean,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        enabled =enabled,
        shape = RoundedCornerShape(
            topStart = 0.dp, bottomStart = 0.dp,
            bottomEnd = 24.dp, topEnd = 24.dp
        ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
            disabledContentColor = MaterialTheme.colorScheme.primary,
        )
    ) {
        Text(
            text = text,
            color = Color.White
            )
    }

}
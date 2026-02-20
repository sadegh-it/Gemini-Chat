package io.github.sadeghi.geminichat.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: String = "پیام را وارد کنید"
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = 24.dp, bottomStart = 24.dp,
                    bottomEnd = 0.dp, topEnd = 0.dp
                )
            ),
        enabled = enabled,
        singleLine = false,
        maxLines = 4,
        placeholder = {
            Text(
                text = placeholder, fontSize = 15.sp, maxLines = 1
            )
        },
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Right),
        shape = RoundedCornerShape(0.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary,
            disabledTextColor = LocalContentColor.current,
            disabledPlaceholderColor = LocalContentColor.current.copy(alpha = 0.5f),
            disabledContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        )

    )
}
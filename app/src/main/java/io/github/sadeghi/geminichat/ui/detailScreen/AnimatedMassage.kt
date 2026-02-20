package io.github.sadeghi.geminichat.ui.detailScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.github.sadeghi.geminichat.data.model.ChatMessage

@Composable
fun AnimatedMessage(
    message: ChatMessage
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true

        }
    }
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(tween(400))
                + slideInVertically(tween(400)) { it / 2 },

        exit = fadeOut(tween(300))
                + slideOutVertically(tween(300))

    ) {
        ChatBubble(message.message, message.isFromUser)
    }
}
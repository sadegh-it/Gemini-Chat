package io.github.sadeghi.geminichat.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.github.sadeghi.geminichat.ui.components.AppButton
import io.github.sadeghi.geminichat.ui.components.AppTextField
import io.github.sadeghi.geminichat.ui.components.SpacerHeight
import io.github.sadeghi.geminichat.ui.detailScreen.AnimatedMessage
import io.github.sadeghi.geminichat.ui.detailScreen.TypingBubble
import io.github.sadeghi.geminichat.viewModel.ChatViewModel

@Composable
fun ChatScreen(
    viewModel: ChatViewModel = hiltViewModel()
) {
    val messages by remember { derivedStateOf { viewModel.messages } }
    var userInput by remember { mutableStateOf("") }
    val isTyping = viewModel.isTyping
    val isLoaded = viewModel.isLoaded
    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {

            listState.animateScrollToItem(messages.size - 1)
        }
    }
    if (!isLoaded)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        } else
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 50.dp
                )
        )
        {
            LazyColumn(

                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                state = listState,
                contentPadding = PaddingValues(vertical = 10.dp)

            ) {
                items(messages) { message ->
                    AnimatedMessage(message)
                }
                if (isTyping) {
                    item {
                        TypingBubble()
                    }
                }
            }
            SpacerHeight(10)
            CompositionLocalProvider(
                LocalLayoutDirection provides LayoutDirection.Rtl
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                )
                {
                    AppTextField(
                        value = userInput,
                        onValueChange = { userInput = it },
                        enabled = !isTyping,
                        modifier = Modifier.weight(1f)
                    )

                    AppButton(
                        onClick = {
                            viewModel.sendMessage(userInput)
                            userInput = ""
                        },
                        enabled = !isTyping && userInput.isNotBlank()
                    )

                }
            }
        }
}


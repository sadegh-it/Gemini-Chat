package io.github.sadeghi.geminichat.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.sadeghi.geminichat.data.model.ChatMessage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
) : ViewModel() {

    private val _messages = mutableStateListOf<ChatMessage>()
    val messages: List<ChatMessage> get() = _messages

    var isTyping by mutableStateOf(false)
        private set

    fun sendMessage(message: String) {
        if (message.isBlank()) return
        _messages.add(ChatMessage(message, true))
        startTypingSimulation()
    }

    private fun startTypingSimulation() {
        viewModelScope.launch {

            isTyping = true
            delay(2000)

            _messages.add(
                ChatMessage(
                    message = " پاسخ به پیام شما: ${messages.last().message}",
                    isFromUser = false
                )
            )

            isTyping = false
        }
    }
}
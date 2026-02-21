package io.github.sadeghi.geminichat.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.sadeghi.geminichat.data.model.ChatMessage
import io.github.sadeghi.geminichat.data.repository.ChatRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository,
) : ViewModel() {

    private val _messages = mutableStateListOf<ChatMessage>()
    val messages: List<ChatMessage> get() = _messages

    var isTyping by mutableStateOf(false)
        private set

    var isLoaded by mutableStateOf(false)
        private set

    private fun loadMassages() {
        viewModelScope.launch {
            _messages.addAll(repository.getAllMassages())
            isLoaded = true
        }
    }

    init {
        loadMassages()
    }

    fun sendMessage(message: String) {
        if (message.isBlank()) return

        val userMsg = ChatMessage(message = message, isFromUser = true)
        _messages.add(userMsg)

        viewModelScope.launch {
            repository.addMessage(userMsg)

        }

        startTypingSimulation()
    }

    private fun startTypingSimulation() {
        viewModelScope.launch {

            isTyping = true
            delay(2000)

            val response = ChatMessage(
                message = " پاسخ به پیام شما: ${messages.last().message}",
                isFromUser = false
            )
            _messages.add(response)

            repository.addMessage(response)

            isTyping = false
        }
    }
}
package io.github.sadeghi.geminichat.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.sadeghi.geminichat.data.model.ChatMassage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
) : ViewModel() {

    private val _massages = mutableStateListOf<ChatMassage>()
    val massages: List<ChatMassage> get() = _massages

    var isTyping by mutableStateOf(false)
        private set

    fun sendMassage(massage: String) {
        if (massage.isBlank()) return
        _massages.add(ChatMassage(massage, true))
        startTypingSimulation()
    }

    private fun startTypingSimulation() {
        viewModelScope.launch {

            isTyping = true
            delay(2000)

            _massages.add(
                ChatMassage(
                    massage = " پاسخ به پیام شما: ${massages.last().massage}",
                    isFromUser = false
                )
            )

            isTyping = false
        }
    }
}
package io.github.sadeghi.geminichat.data.repository

import io.github.sadeghi.geminichat.data.model.ChatMessage
import io.github.sadeghi.geminichat.database.dao.MessagesDao
import io.github.sadeghi.geminichat.utils.toEntity
import io.github.sadeghi.geminichat.utils.toUiModel

class ChatRepository(
    private val dao: MessagesDao,
) {

    suspend fun addMessage(massage: ChatMessage) {
        dao.addMessage(massage.toEntity())
    }


    suspend fun getAllMassages(): List<ChatMessage> {
        return dao.getAllMessages().map { it.toUiModel() }
    }
}
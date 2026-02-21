package io.github.sadeghi.geminichat.utils

import io.github.sadeghi.geminichat.data.model.ChatMessage
import io.github.sadeghi.geminichat.database.entity.ChatMessageEntity

fun ChatMessage.toEntity(): ChatMessageEntity {
    return ChatMessageEntity(
        id = 0,
        message = this.message,
        isFromUser = this.isFromUser
    )

}

fun ChatMessageEntity.toUiModel(): ChatMessage {
    return ChatMessage(
        message = this.message,
        isFromUser = this.isFromUser
    )
}
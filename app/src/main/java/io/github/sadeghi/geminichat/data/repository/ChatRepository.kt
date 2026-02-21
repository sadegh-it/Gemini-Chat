package io.github.sadeghi.geminichat.data.repository

import io.github.sadeghi.geminichat.data.model.ChatMessage
import io.github.sadeghi.geminichat.data.model.geminiModels.Content
import io.github.sadeghi.geminichat.data.model.geminiModels.GeminiRequest
import io.github.sadeghi.geminichat.data.model.geminiModels.Part
import io.github.sadeghi.geminichat.data.remote.GeminiApiService
import io.github.sadeghi.geminichat.database.dao.MessagesDao
import io.github.sadeghi.geminichat.utils.toEntity
import io.github.sadeghi.geminichat.utils.toUiModel

class ChatRepository(
    private val dao: MessagesDao,
    private val apiService: GeminiApiService
) {

    private val apikey = "Your API Key"

    suspend fun addMessage(massage: ChatMessage) {
        dao.addMessage(massage.toEntity())
    }


    suspend fun getAllMassages(): List<ChatMessage> {
        return dao.getAllMessages().map { it.toUiModel() }
    }

    suspend fun getGeminiChatCompletion(): String {
        val previousMassages = dao.getAllMessages().map {
            it.toUiModel()
        }.takeLast(10) // فقط 10 تا پیام آخر یادش باشه نمایش بده خروجی محدود یاشه

        val contents = previousMassages.map {
            Content(
                role = if (it.isFromUser) "user" else "model",
                parts = listOf(Part(text = it.message))
            )
        }

        val request = GeminiRequest(contents = contents)

        val response = apiService.generateContent(
            request,
            apikey
        )

        return if (response.isSuccessful) {
            response.body()?.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
                ?: "پاسخی دریافت نشد!"
        } else {
            "خطا : ${response.code()}"
        }


    }

}
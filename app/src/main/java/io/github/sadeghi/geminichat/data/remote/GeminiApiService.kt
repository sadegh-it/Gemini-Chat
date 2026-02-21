package io.github.sadeghi.geminichat.data.remote

import io.github.sadeghi.geminichat.data.model.geminiModels.GeminiRequest
import io.github.sadeghi.geminichat.data.model.geminiModels.GeminiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface GeminiApiService {

    @POST("v1beta/models/gemini-2.5-flash:generateContent")
    suspend fun generateContent(
        @Body request: GeminiRequest,
        @Header("x-goog-api-key") apiKey: String,
    ): Response<GeminiResponse>
}
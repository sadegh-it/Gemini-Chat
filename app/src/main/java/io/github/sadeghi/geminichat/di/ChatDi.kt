package io.github.sadeghi.geminichat.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.sadeghi.geminichat.data.remote.GeminiApiService
import io.github.sadeghi.geminichat.data.repository.ChatRepository
import io.github.sadeghi.geminichat.database.dao.MessagesDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ChatDi {

    @Provides
    @Singleton
    fun providesRepository(dao: MessagesDao, apiService: GeminiApiService): ChatRepository =
        ChatRepository(dao, apiService)
}
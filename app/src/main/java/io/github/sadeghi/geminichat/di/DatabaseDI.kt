package io.github.sadeghi.geminichat.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.sadeghi.geminichat.data.repository.ChatRepository
import io.github.sadeghi.geminichat.database.dao.MessagesDao
import io.github.sadeghi.geminichat.database.mainDB.MainDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseDI {

    @Provides
    @Singleton
    fun provideDatabase(appContext: Application): MainDatabase =
        Room.databaseBuilder(
            appContext,
            MainDatabase::class.java,
            "chat_db"
        ).build()

    @Provides
    fun provideDao(db: MainDatabase): MessagesDao = db.messageDao()

    @Provides
    fun providesRepository(dao: MessagesDao): ChatRepository =
        ChatRepository(dao)
}
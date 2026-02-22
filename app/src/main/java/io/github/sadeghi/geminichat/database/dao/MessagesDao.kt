package io.github.sadeghi.geminichat.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.github.sadeghi.geminichat.database.entity.ChatMessageEntity

@Dao
interface MessagesDao {

    @Insert
    suspend fun addMessage(massage: ChatMessageEntity)

    @Query("SELECT * FROM messages")
    suspend fun getAllMessages():List<ChatMessageEntity>


}
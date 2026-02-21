package io.github.sadeghi.geminichat.database.mainDB

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.sadeghi.geminichat.database.dao.MessagesDao
import io.github.sadeghi.geminichat.database.entity.ChatMessageEntity

@Database(
    entities = [ChatMessageEntity::class],
    version = 1
)
abstract class MainDatabase : RoomDatabase() {

    abstract fun messageDao(): MessagesDao

}
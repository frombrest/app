package by.audiobooks.mob.data.db

import app.cash.sqldelight.db.SqlDriver
import by.audiobooks.mob.data.network.dto.Data
import by.audiobooks.mob.domain.Book
import by.audiobooks.mob.domain.Link
import by.audiobooks.mob.domain.LinkType
import by.audiobooks.mob.domain.Narration
import by.audiobooks.mob.domain.Person
import by.audiobooks.mob.domain.Publisher
import by.audiobooks.mob.domain.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class DatabaseHelper(sqlDriver: SqlDriver) {

    internal val database by lazy { AudiobooksByDB(sqlDriver) }

    suspend fun replaceData(newData: Data): Unit = withContext(Dispatchers.IO) {
        database.replaceData(newData)
    }

    fun getAllBooks(): Flow<List<Book>> = database.getAllBooks()

    fun getAllNarrations(): Flow<List<Narration>> = database.getAllNarrations()

    fun getAllPersons(): Flow<List<Person>> = database.getAllPersons()

    fun getAllPublishers(): Flow<List<Publisher>> = database.getAllPublishers()

    fun getAllTags(): Flow<List<Tag>> = database.getAllTags()

    fun getAllLinks(): Flow<List<Link>> = database.getAllLinks()

    fun getAllLinkTypes(): Flow<List<LinkType>> = database.getAllLinkTypes()

}

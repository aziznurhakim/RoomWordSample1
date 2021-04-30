package com.example.roomwordsample

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WordRepository {
    fun insert(word: word.Word) {
        TODO("Not yet implemented")
    }

    class WordRepository(private val wordDao: WordDao) {

        // Room executes all queries on a separate thread.
        // Observed Flow will notify the observer when the data has changed.
        val allWords: Flow<List<word.Word>> = wordDao.getAlphabetizedWords()

        // By default Room runs suspend queries off the main thread, therefore, we don't need to
        // implement anything else to ensure we're not doing long running database work
        // off the main thread.
        @Suppress("RedundantSuspendModifier")
        @WorkerThread
        suspend fun insert(word: word.Word) {
            wordDao.insert(word)
        }
    }

}

private fun WordDao.getAlphabetizedWords(): Flow<List<word.Word>> {
    TODO("Not yet implemented")
}
